package com.duydan.mysecurity.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final boolean status = false;
    private String message;
    private Object errors;
}
