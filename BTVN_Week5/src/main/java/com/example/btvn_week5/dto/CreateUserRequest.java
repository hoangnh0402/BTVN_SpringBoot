package com.example.btvn_week5.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    private String username;
    private String password;
    private String confirmPassword;

}
