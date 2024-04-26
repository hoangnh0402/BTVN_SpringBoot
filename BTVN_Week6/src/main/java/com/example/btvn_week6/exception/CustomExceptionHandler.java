package com.example.btvn_week6.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public AlreadyExistsException handleAlreadyExistsException(AlreadyExistsException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new AlreadyExistsException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public NotFoundException handleNotFoundException(NotFoundException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new NotFoundException(ex.getThongBao(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
