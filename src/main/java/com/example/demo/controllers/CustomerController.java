package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/getByFirstName/{firstName}")
    List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        return customerService.getByFirstName(firstName);
    }

    @GetMapping("/customer/{id}")
    Optional<Customer> getById(@PathVariable("id") long id, @RequestParam(name = "includeCancelledPurchases", required = false, defaultValue = "false") Boolean includeCancelledPurchases) {
        return customerService.getById(id, includeCancelledPurchases);
    }

    @GetMapping("/customer/getByLastName/{lastName}")
    List<Customer> getByLastName(@PathVariable("lastName") String lastName) {
        return customerService.getByLastName(lastName);
    }

    @GetMapping("/customer/purchasedProducts")
    List<Product> getPurchasedProducts() {
        return customerService.getPurchasedProducts();
    }
}
