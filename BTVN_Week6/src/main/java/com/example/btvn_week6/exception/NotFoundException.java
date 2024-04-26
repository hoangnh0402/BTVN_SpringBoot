package com.example.btvn_week6.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private String thongBao;

    private HttpStatus httpStatus;

    public NotFoundException(String message, HttpStatus httpStatus) {
        this.thongBao = message;
        this.httpStatus = httpStatus;
    }

    public String getThongBao() {
        return thongBao;
    }

    public void setThongBao(String thongBao) {
        this.thongBao = thongBao;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
