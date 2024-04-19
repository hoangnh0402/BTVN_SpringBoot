package com.example.btvn_week5.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordNotMatchException extends Exception{
    private String message;
    private HttpStatus status;
    public PasswordNotMatchException(String message) {
        this.message =message;
        status = HttpStatus.BAD_REQUEST;
    }
}
