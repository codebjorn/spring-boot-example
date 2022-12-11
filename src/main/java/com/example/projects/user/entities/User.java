package com.example.projects.user.entities;

import com.example.projects.workspace.entities.Workspace;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Role> roles;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Workspace> workspaces;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;

        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;

        return this;
    }

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public User setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;

        return this;
    }
}
