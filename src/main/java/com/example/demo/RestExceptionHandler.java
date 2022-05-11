package com.example.demo;

import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleConflict(NotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error(ex.getError().toString())
                .code(ex.getError().getCode())
                .message(ex.getMessage())
                .build();
        return handleExceptionInternal(ex, errorResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
