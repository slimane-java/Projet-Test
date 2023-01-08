package com.example.miniProjet.classValidation;

import com.example.miniProjet.Service.ClientService;
import com.example.miniProjet.customAnnotation.CheckClient1;
import com.example.miniProjet.dao.ClientRepository;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.orders.OrdersPostDto;
import lombok.RequiredArgsConstructor;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CheckClientValidator implements ConstraintValidator<CheckClient1, ClientGetDto> {


    private final ClientRepository clientRepository;

    @Override
    public void initialize(CheckClient1 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClientGetDto clientGetDto, ConstraintValidatorContext constraintValidatorContext) {

        return clientRepository.findById(clientGetDto.getId()).isPresent();
    }
}
