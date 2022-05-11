package com.example.demo.exception;

import lombok.Getter;

public class NotFoundException extends Exception {
    @Getter
    private static final int STATUS_CODE = 404;

    public NotFoundException(String message) {
        super(message);
    }
}
