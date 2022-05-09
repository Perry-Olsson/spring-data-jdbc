package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public List<Customer> getByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public Optional<Customer> getById(long id, Boolean includeCancelledPurchases) {
        if (!includeCancelledPurchases) {
            return repository.findByIdWithOutCancelledPurchases(id);
        }
        return repository.findById(id);
    }
}
