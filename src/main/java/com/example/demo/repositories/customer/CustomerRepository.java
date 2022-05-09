package com.example.demo.repositories.customer;

import com.example.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, PurchaseQueries {
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
