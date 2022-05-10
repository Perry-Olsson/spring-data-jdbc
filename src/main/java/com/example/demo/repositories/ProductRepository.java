package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    @Query(value = "SELECT DISTINCT * FROM PRODUCT INNER JOIN PURCHASE ON PURCHASE.PRODUCT_ID = PRODUCT.ID WHERE PURCHASE.CUSTOMER_ID = :customer_id AND (PURCHASE.CANCELLED = FALSE OR PURCHASE.CANCELLED = :include_cancelled_purchases)")
    List<Product> findByCustomerPurchaseId(@Param("customer_id") long customerId, @Param("include_cancelled_purchases") boolean includeCancelledPurchases);
}
