package com.duydan.mysecurity.exceptions;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MethodNotSupportedException {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleException() {
        return "NON";
    }
}
