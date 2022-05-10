package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, PurchaseQueries {
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    @Query("SELECT DISTINCT PRODUCT.ID, PRODUCT.SKU, PRODUCT.NAME, PRODUCT.DESCRIPTION FROM CUSTOMER INNER JOIN PURCHASE ON PURCHASE.CUSTOMER_ID = CUSTOMER.ID INNER JOIN PRODUCT ON PRODUCT.ID = PURCHASE.PRODUCT_ID WHERE CUSTOMER.ID = :customer_id")
    List<Product> findPurchasedProducts(@Param(value = "customer_id") long customerId);
}
