package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("""
    SELECT product.id, product.sku, product.name, product.description, product.category_name, product_category.category_description FROM product
    INNER JOIN product_category ON product.category_name = product_category.category_name
    WHERE product.name = :name;
    """)
    List<Product> findByName(@Param(value = "name") String name);
}
