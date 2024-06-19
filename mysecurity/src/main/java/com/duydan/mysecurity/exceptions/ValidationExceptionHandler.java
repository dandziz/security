package com.duydan.mysecurity.exceptions;

import com.duydan.mysecurity.dto.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException e) {
        String errorMessage = "Request không hợp lệ";
        if (e.getBindingResult().hasErrors()) {
            Map<String, List<String>> errors = new HashMap<>();
            e.getBindingResult().getAllErrors().forEach((error) -> {
                String field = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                assert message != null;
                List<String> messages = List.of(message);
                errors.put(field, messages);
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
}
