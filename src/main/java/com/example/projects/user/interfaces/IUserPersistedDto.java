package com.example.projects.user.interfaces;

import java.util.List;

public interface IUserPersistedDto {
    Long getId();

    String getName();

    String getUsername();

    String getEmail();

    String getPassword();

    List<Long> getRoles();

    List<Long> getWorkspaces();
}
