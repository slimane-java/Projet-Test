package com.example.miniProjet.customAnnotation;

import com.example.miniProjet.classValidation.PasswordValiddator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValiddator.class)
@Documented
public @interface PasswordValidator {
    String message() default "password should be the same";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
