package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Repository
public class PurchaseQueriesImpl extends BaseCustomerMethods implements PurchaseQueries {
    private static final String SELECT_PRODUCT_WITH_CATEGORY = """
            SELECT * FROM product INNER JOIN product_category ON product.category_name = product_category.category_name
            """;
    private static final String PURCHASES_BY_CUSTOMER_ID_NOT_CANCELLED_QUERY = """
    SELECT purchase.id, purchase.product_id FROM purchase WHERE purchase.customer_id = ? AND purchase.cancelled = FALSE;
    """;
    private static final Function<Set<Long>, String>  productsByPurchaseIds = (Set<Long> ids) ->
        String.format("%s WHERE product.id %s;", SELECT_PRODUCT_WITH_CATEGORY, buildInQuery(ids));

    public static <T> String buildInQuery(Collection<T> it) {
        String placeHolders = "?,".repeat(Math.max(0, it.size() - 1)) +
                "?";
        return String.format("IN (%s)", placeHolders);
    }

    @Autowired
    PurchaseQueriesImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<Customer> findByIdWithOutCancelledPurchases(long id) {
        Optional<Customer> customer = findById(id);
        if (customer.isEmpty()) {
            return customer;
        }
        List<Purchase> purchases = jdbcTemplate.query(PURCHASES_BY_CUSTOMER_ID_NOT_CANCELLED_QUERY, new PurchaseMapper(), id);
        Set<Long> purchaseIds = purchases.stream().map(Purchase::getProductId).collect(Collectors.toSet());
        List<Product> products = jdbcTemplate.query(productsByPurchaseIds.apply(purchaseIds), new ProductMapper(), purchaseIds.toArray());
        Map<Long, Product> productsById = products.stream().collect(Collectors.toMap(Product::getId, (p) -> p));
        for (Purchase purchase : purchases) {
            purchase.setProduct(productsById.get(purchase.getProductId()));
        }
        customer.get().setPurchases(purchases);
        return customer;
    }

    private static class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setSku(rs.getLong("sku"));
            product.setDescription(rs.getString("description"));
            product.setCategoryName(rs.getString("category_name"));
            product.setCategoryDescription(rs.getString("category_description"));
            return product;
        }
    }
}
