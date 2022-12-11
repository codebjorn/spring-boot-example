package com.example.projects.user.controllers;


import com.example.projects.user.services.UserService;
import com.example.projects.user.dtos.UserCreationDto;
import com.example.projects.user.dtos.UserPersistedDto;
import com.example.projects.user.dtos.UserUpdateDto;
import com.example.projects.user.mappers.UserMapper;
import com.example.projects.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RolesAllowed("Admin")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;


    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("")
    public List<UserPersistedDto> all() {
        return service.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public UserPersistedDto create(@Validated @RequestBody UserCreationDto userCreationDto) {
        User user = mapper.toUser(userCreationDto);
        User savedUser = service.create(user);
        return mapper.toDto(savedUser);
    }

    @GetMapping("/{id}")
    public UserPersistedDto get(@PathVariable Long id) {
        User user = service.get(id);
        return mapper.toDto(user);
    }

    @PutMapping("/{id}")
    public UserPersistedDto update(@PathVariable Long id, @Validated @RequestBody UserUpdateDto userUpdateDto) {
        User user = mapper.toUser(userUpdateDto);
        User updatedUser = service.update(id, user);

        return mapper.toDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
