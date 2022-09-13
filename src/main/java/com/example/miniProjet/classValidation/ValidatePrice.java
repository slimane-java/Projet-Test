package com.example.miniProjet.classValidation;

import com.example.miniProjet.exception.ValidatePriceExceptionHandler;

public class ValidatePrice {
    public float validate(float price) {
        if(price < 0)  {
            throw  new ValidatePriceExceptionHandler("price should be greater than or equals 0");
        }
        return price;
    }
}
