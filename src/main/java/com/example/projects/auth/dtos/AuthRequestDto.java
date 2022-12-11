package com.example.projects.auth.dtos;

import javax.validation.constraints.NotNull;

public class AuthRequestDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public AuthRequestDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthRequestDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
