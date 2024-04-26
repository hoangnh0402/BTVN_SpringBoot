package com.example.btvn_week6.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends RuntimeException{
    private String message;

    private HttpStatus httpStatus;

    public AlreadyExistsException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
