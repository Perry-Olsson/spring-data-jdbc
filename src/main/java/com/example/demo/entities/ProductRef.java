package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("PURCHASE")
@Data
public class ProductRef {
    long productId;
}
