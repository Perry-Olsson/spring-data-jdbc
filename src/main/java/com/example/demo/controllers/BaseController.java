package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected ResponseEntity.BodyBuilder httpOk() {
        return ResponseEntity.ok();
    }
}
