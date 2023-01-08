package com.example.miniProjet.classValidation;

import com.example.miniProjet.customAnnotation.PasswordValidator;
import com.example.miniProjet.dto.ClientPostDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValiddator implements ConstraintValidator<PasswordValidator, ClientPostDto> {

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClientPostDto clientPostDto, ConstraintValidatorContext constraintValidatorContext) {
        if(clientPostDto.getPasswordClient().equals(clientPostDto.getPasswordConfermClient())){
            return true;
        }
        return false;
    }
}
