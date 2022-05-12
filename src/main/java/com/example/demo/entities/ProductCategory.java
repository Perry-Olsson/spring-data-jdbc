package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class ProductCategory {
    @Id
    String categoryName;
    @Column("category_description")
    String categoryDescription;
}
