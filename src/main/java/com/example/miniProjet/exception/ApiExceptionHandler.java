package com.example.miniProjet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), "Resource Not Found");
    }

    @ExceptionHandler(value = ClassNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage classNotFoundException(ClassNotFoundException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), "Class Not Found On The Classpath");
    }

    @ExceptionHandler(value = InvocationTargetException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage invocationTargetException(InvocationTargetException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), "Failed To Invoke Method or Constructor");
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorMessage authorisedException(AuthenticationException ex) {
        System.out.print("Teste Status "+ ex.getMessage());
        return new ErrorMessage(HttpStatus.UNAUTHORIZED.value(), new Date(), ex.getMessage(), "you need to Authorised");
    }

    @ExceptionHandler(value = AlreadyExists.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage alreadyExists(AlreadyExists ex) {
        System.out.print("Teste Status "+ ex.getMessage());
        return new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), ex.getMessage(), "create refused");
    }

    @ExceptionHandler(value = ValidatePriceExceptionHandler.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage validatePriceExceptionHandler(ValidatePriceExceptionHandler ex) {
        System.out.print("Teste Status "+ ex.getMessage());
        return new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), ex.getMessage(), "price refused");
    }
}
