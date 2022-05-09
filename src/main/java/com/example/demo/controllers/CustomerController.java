package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductRef;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Customer> customers = customerRepository.findByFirstName(firstName)
                .stream()
                .peek((Customer c) -> c.setPurchasedProducts(productRepository.findAllById(c.getProductIds()))).collect(Collectors.toList());
        return customers;
    }

    @GetMapping("/customer/getByLastName/{lastName}")
    List<Customer> ping(@PathVariable("lastName") String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
