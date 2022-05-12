package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Purchase {
    @Id
    long id;
    @Transient
    Long customerId;
    long productId;
    boolean cancelled;
    @Transient
    Product product;
}
