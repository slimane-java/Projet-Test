package com.example.miniProjet.customAnnotation;

import com.example.miniProjet.classValidation.CheckClientValidator;
import jakarta.validation.Constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckClientValidator.class)
@Documented
public @interface CheckClient1 {
    String message() default "client does not found";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
