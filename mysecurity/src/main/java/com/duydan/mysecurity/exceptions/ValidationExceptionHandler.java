package com.duydan.mysecurity.exceptions;

import com.duydan.mysecurity.dto.responses.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter.*;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException e) {
        String errorMessage = "Request không hợp lệ";
        if (e.getBindingResult().hasErrors()) {
            Map<String, List<String>> errors = new HashMap<>();
            e.getBindingResult().getAllErrors().forEach((error) -> {
                try {
                    String field = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    assert message != null;
                    List<String> messages = List.of(message);
                    errors.put(field, messages);
                } catch (Exception ex) {
                    int length = Objects.requireNonNull(error.getArguments()).length;
                    String field = error.getArguments()[length - 1].toString();
                    errors.put(field, List.of(Objects.requireNonNull(error.getDefaultMessage())));
                }
            });
            return new ResponseEntity<>(new ErrorResponse("Somethings when wrong...", errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("message", "Required request body is missing or malformed");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            errors.put(cv.getPropertyPath().toString().split("\\.")[1], cv.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
