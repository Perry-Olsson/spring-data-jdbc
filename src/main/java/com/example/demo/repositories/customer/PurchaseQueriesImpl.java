package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PurchaseQueriesImpl extends BaseCustomerMethods implements PurchaseQueries {
    private static final String PURCHASES_BY_CUSTOMER_ID_NOT_CANCELLED_QUERY = """
    SELECT PURCHASE.ID, PURCHASE.PRODUCT_ID FROM PURCHASE WHERE PURCHASE.CUSTOMER_ID = ? AND PURCHASE.CANCELLED = FALSE;
    """;

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
        customer.get().setPurchases(purchases);
        return customer;
    }
}
