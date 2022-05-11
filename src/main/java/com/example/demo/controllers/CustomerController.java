package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.exception.NotFoundException;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController extends BaseController {
    CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/getByFirstName/{firstName}")
    ResponseEntity<List<Customer>> getByFirstName(@PathVariable("firstName") String firstName) {
        List<Customer> customers = customerService.getByFirstName(firstName);
        return httpOk().body(customers);
    }

    @GetMapping("/customer/{id}")
    ResponseEntity<Customer> getById(@PathVariable("id") long id,
                                    @RequestParam(name = "includeCancelledPurchases", required = false, defaultValue = "false") Boolean includeCancelledPurchases
    ) throws NotFoundException {
        Customer customer = customerService.getById(id, includeCancelledPurchases);
        return httpOk().body(customer);
    }

    @GetMapping("/customer/getByLastName/{lastName}")
    ResponseEntity<List<Customer>> getByLastName(@PathVariable("lastName") String lastName) {
        List<Customer> customers = customerService.getByLastName(lastName);
        return httpOk().body(customers);
    }

    @GetMapping("/customer/purchasedProducts/{customerId}")
    ResponseEntity<List<Product>> getPurchasedProducts(@PathVariable(value = "customerId") long customerId) {
        List<Product> products = customerService.getPurchasedProducts(customerId);
        return httpOk().body(products);
    }
}
