package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum Error {
    CUSTOMER_ID_NOT_FOUND(1);
    final int code;

    Error(int code) {
        this.code = code;
    }
}
