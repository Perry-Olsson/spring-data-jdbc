package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    @Id
    long id;
    private String firstName;
    private String lastName;

    @MappedCollection(keyColumn = "CUSTOMER_ID", idColumn = "CUSTOMER_ID")
    private List<Purchase> purchases = new ArrayList<>();
}
