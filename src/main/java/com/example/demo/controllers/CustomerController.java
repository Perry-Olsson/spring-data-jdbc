package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer/getByFirstName/{firstName}")
    List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @GetMapping("/customer/getByLastName/{lastName}")
    List<Customer> ping(@PathVariable("lastName") String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
