package com.duydan.mysecurity.common.validation.fieldsvaluematch;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {
    String message() default "Fields values don't match!";
    Class<? extends Payload>[] payload() default {};
    Class<?>[] groups() default {};

    String field();
    String fieldMatch();

}
