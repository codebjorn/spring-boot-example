package com.example.projects.user.dtos;
import com.example.projects.user.interfaces.IUserDto;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

public class UserUpdateDto implements IUserDto {
    private String name;
    private String username;

    @Email
    private String email;
    private String password;
    private List<Long> roles = new ArrayList<>();
    private List<Long> workspaces = new ArrayList<>();

    public String getName() {
        return name;
    }

    public UserUpdateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserUpdateDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public UserUpdateDto setRoles(List<Long> roles) {
        this.roles = roles;
        return this;
    }

    public List<Long> getWorkspaces() {
        return workspaces;
    }

    public UserUpdateDto setWorkspaces(List<Long> workspaces) {
        this.workspaces = workspaces;
        return this;
    }
}
