package com.example.projects.user.dtos;

import com.example.projects.user.interfaces.IUserPersistedDto;

public class UserPersistedDto extends UserUpdateDto implements IUserPersistedDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public UserPersistedDto setId(Long id) {
        this.id = id;
        return this;
    }
}
