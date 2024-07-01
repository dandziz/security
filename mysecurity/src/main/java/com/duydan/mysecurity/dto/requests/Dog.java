package com.duydan.mysecurity.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Dog {
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
}
