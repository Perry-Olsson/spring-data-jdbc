package com.example.demo.services;

import com.example.demo.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Autowired
    @Bean
    CustomerService customerService(CustomerRepository repository) {
        return new CustomerService(repository);
    }
}
