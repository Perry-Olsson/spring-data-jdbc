package com.example.demo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    private int code;
    private String error;
    private String message;
}
