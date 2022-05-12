package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    long id;
    long sku;
    String name;
    String description;
    String categoryName;
    String categoryDescription;
}
