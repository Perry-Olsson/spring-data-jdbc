package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    CustomerRepository customerRepository;

    @Autowired
    MainController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer/getByFirstName/{firstName}")
    Iterable<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @GetMapping("/getByLastName")
    Iterable<Customer> ping(@Param("lastName") String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
