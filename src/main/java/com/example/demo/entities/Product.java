package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    long id;
    long sku;
    String name;
    String description;
}
