package com.bulut.validation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ValidationAdvice {

    @ExceptionHandler
    public ResponseEntity handle(ConstraintViolationException constraintViolationException) {
        return new ResponseEntity(constraintViolationException.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
