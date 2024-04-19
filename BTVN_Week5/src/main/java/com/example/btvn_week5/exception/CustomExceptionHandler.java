package com.example.btvn_week5.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class PasswordNotMatchException extends RuntimeException {
        public PasswordNotMatchException(String message) {
            super(message);
        }
    }

}
