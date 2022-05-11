package com.example.demo.exception;


import lombok.Getter;

@Getter
public class NotFoundException extends Exception {
    public static final int STATUS_CODE = 404;
    private final Error error;

    public NotFoundException(Error error, String message) {
        super(message);
        this.error = error;
    }
}
