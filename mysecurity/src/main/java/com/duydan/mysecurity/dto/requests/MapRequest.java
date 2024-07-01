package com.duydan.mysecurity.dto.requests;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MapRequest {
    @Valid
    private Cat catRequest;
    private String name;
}
