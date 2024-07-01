package com.duydan.mysecurity.dto.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cat {
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    @Valid
    private Dog dog;
}
