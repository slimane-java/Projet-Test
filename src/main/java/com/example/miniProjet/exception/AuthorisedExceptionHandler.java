package com.example.miniProjet.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthorisedExceptionHandler extends AuthenticationException {

    public AuthorisedExceptionHandler(String message) {
        super(message);
    }
}
