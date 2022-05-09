package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/customer/getByFirstName/{firstName}")
    List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @GetMapping("/customer/{id}")
    Optional<Customer> getById(@PathVariable("id") long id, @RequestParam(name = "includeCancelledPurchases", required = false, defaultValue = "false") Boolean includeCancelledPurchases) {
        if (!includeCancelledPurchases) {
            return customerRepository.findByIdWithOutCancelledPurchases(id);
        }
        return customerRepository.findById(id);
    }

    @GetMapping("/customer/getByLastName/{lastName}")
    List<Customer> ping(@PathVariable("lastName") String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
