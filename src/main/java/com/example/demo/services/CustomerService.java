package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.exception.Error;
import com.example.demo.exception.NotFoundException;
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

    public Customer getById(long id, Boolean includeCancelledPurchases) throws NotFoundException {
        Optional<Customer> customer = includeCancelledPurchases
                ? repository.findById(id)
                : repository.findByIdWithOutCancelledPurchases(id);

        if (customer.isEmpty()) {
            throw new NotFoundException(Error.CUSTOMER_ID_NOT_FOUND, String.format("Customer with id: %d was not found", id));
        }

        return customer.get();
    }

    public List<Product> getPurchasedProducts(long customerId) {
        return repository.findPurchasedProducts(customerId);
    }
}
