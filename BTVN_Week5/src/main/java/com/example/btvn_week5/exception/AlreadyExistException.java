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
public class AlreadyExistException extends Exception{
    private String message;
    private HttpStatus status;
    public AlreadyExistException(String message) {
        this.message =message;
        status = HttpStatus.BAD_REQUEST;
    }
}
