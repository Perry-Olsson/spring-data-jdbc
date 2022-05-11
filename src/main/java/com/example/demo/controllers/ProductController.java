package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController extends BaseController {
    ProductRepository productRepository;

    @Autowired
    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/{name}")
    ResponseEntity<List<Product>> findAllByName(@PathVariable String name) {
        List<Product> products = productRepository.findByName(name);
        return httpOk().body(products);
    }
}
