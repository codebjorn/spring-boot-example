package com.example.projects.user.dtos;

import com.example.projects.user.interfaces.IUserDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserCreationDto implements IUserDto {
    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private List<Long> roles;

    @NotNull
    private List<Long> workspaces;

    @Override
    public String getName() {
        return name;
    }

    public UserCreationDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserCreationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public UserCreationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public UserCreationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public List<Long> getRoles() {
        return roles;
    }

    public UserCreationDto setRoles(List<Long> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public List<Long> getWorkspaces() {
        return workspaces;
    }

    public UserCreationDto setWorkspaces(List<Long> workspaces) {
        this.workspaces = workspaces;
        return this;
    }
}
