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

    @Query("""
    SELECT DISTINCT product.id, product.sku, product.name, product.description FROM customer
    INNER JOIN purchase ON purchase.customer_id = customer.id
    INNER JOIN product ON product.id = purchase.product_id
    WHERE customer.id = :customer_id
    """)
    List<Product> findPurchasedProducts(@Param(value = "customer_id") long customerId);
}
