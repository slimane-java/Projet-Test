package com.example.miniProjet.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionEnum {
    UNAUTHORIZED("login or password is wrong"),
    DPLICATED("you can add is already existe");

    private String message;


    @Override
    public String toString() {
        return message;
    }
}
