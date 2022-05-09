package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;

import java.util.Optional;

public interface PurchaseQueries {
    Optional<Customer> findByIdWithOutCancelledPurchases(long id);
}
