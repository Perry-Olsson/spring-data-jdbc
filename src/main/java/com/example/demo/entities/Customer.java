package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Customer {
    @Id @Getter
    long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
}
