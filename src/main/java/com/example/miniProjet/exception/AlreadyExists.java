package com.example.miniProjet.exception;

import lombok.AllArgsConstructor;


public class AlreadyExists extends RuntimeException{
    public AlreadyExists(String message) {
        super(message);
    }
}
