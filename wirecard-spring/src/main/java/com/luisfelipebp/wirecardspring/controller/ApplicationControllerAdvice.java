package com.luisfelipebp.wirecardspring.controller;

import com.luisfelipebp.wirecardspring.model.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ValidationError> handleNotFoundException(MethodArgumentNotValidException ex){
        ValidationError validationError = new ValidationError(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(validationError);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ValidationError> handleNotFoundException(Exception ex){
        ValidationError validationError = new ValidationError(ex.getMessage());
        return ResponseEntity.badRequest().body(validationError);
    }

}
