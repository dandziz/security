package com.duydan.mysecurity.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionHandler() {
        Map<String, Object> error = new HashMap<>();
        error.put("status", false);
        error.put("message", "Internal Server Error");
        return ResponseEntity.status(500).body(error);
    }
}
