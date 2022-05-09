package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Customer {
    @Id
    long id;
    private String firstName;
    private String lastName;

    @JsonIgnore
    @MappedCollection(idColumn = "CUSTOMER_ID")
    private Set<ProductRef> purchasedProductIds = new HashSet<>();

    @JsonIgnore
    public Set<Long> getProductIds() {
        return purchasedProductIds.stream().map(ProductRef::getProductId).collect(Collectors.toSet());
    }

    @Transient
    Iterable<Product> purchasedProducts = new ArrayList<>();
}
