package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Product {
    @Id @Getter
    long id;
    @Setter @Getter
    long sku;
    @Setter @Getter
    String name;
    @Setter @Getter
    String description;
}
