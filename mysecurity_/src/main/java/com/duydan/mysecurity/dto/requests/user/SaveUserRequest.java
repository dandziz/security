package com.duydan.mysecurity.dto.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SaveUserRequest {
    @NotEmpty(message = "Username là trường bắt buộc.")
    private String username;

    @NotEmpty(message = "Name là trường bắt buộc.")
    private String name;

    @NotEmpty(message = "Email là trường bắt buộc.")
    @Email(message = "Email không đúng định dạng.")
    private String email;

    @NotEmpty(message = "Password là trường bắt buộc.")
    private String password;

    @NotNull(message = "Enabled là trường bắt buộc.")
    private Boolean enabled;

    @NotNull(message = "Department là trường bắt buộc.")
    private Long departmentId;
}
