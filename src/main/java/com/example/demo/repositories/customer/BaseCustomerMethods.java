package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class BaseCustomerMethods {
    private final static String CUSTOMER_BY_ID_QUERY = """
    SELECT customer.id, customer.first_name, customer.last_name FROM customer WHERE customer.id = ?;
    """;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public BaseCustomerMethods(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected Optional<Customer> findById(long id) {
        List<Customer> customer = jdbcTemplate.query(CUSTOMER_BY_ID_QUERY, new CustomerMapper(), id);
        return Optional.ofNullable(customer.isEmpty() ? null : customer.get(0));
    }
}
