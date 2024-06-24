package com.duydan.mysecurity.dto.requests.user;

import com.duydan.mysecurity.common.validation.fieldsvaluematch.FieldsValueMatch;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@FieldsValueMatch(
        field = "newPassword",
        fieldMatch = "confirmNewPassword",
        message = "Passwords do not match!"
)
public class ChangePasswordRequest {
    @NotEmpty
    private String currentPassword;
    @NotEmpty
    private String newPassword;
    @NotEmpty
    private String confirmNewPassword;
}
