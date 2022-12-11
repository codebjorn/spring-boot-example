package com.example.projects.auth.dtos;

import javax.validation.constraints.NotNull;

public class AuthResponseDto {
    private String token;

    public String getToken() {
        return token;
    }

    public AuthResponseDto setToken(String token) {
        this.token = token;
        return this;
    }
}
