package com.example.projects.user.mappers;

import com.example.projects.user.dtos.UserPersistedDto;
import com.example.projects.user.interfaces.IUserPersistedDto;
import com.example.projects.user.repositories.RoleRepository;
import com.example.projects.user.repositories.UserRepository;
import com.example.projects.workspace.entities.Workspace;
import com.example.projects.user.entities.Role;
import com.example.projects.user.entities.User;
import com.example.projects.user.interfaces.IUserDto;
import com.example.projects.workspace.repositories.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private UserRepository userRepository;

    public UserPersistedDto toDto(User user) {
        List<Long> roles = user.getRoles()
                .stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Long> workspaces = user.getWorkspaces()
                .stream()
                .map(Workspace::getId)
                .collect(Collectors.toList());

        return (UserPersistedDto) new UserPersistedDto()
                .setId(user.getId())
                .setName(user.getName())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRoles(roles)
                .setWorkspaces(workspaces);
    }

    public User toUser(IUserDto userDto) {
        List<Role> roles = userDto.getRoles()
                .stream()
                .map(id -> roleRepository.findById(id).orElse(null))
                .collect(Collectors.toList());
        List<Workspace> workspaces = userDto.getWorkspaces()
                .stream()
                .map(id -> workspaceRepository.findById(id).orElse(null))
                .collect(Collectors.toList());

        return new User()
                .setName(userDto.getName())
                .setUsername(userDto.getUsername())
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword())
                .setRoles(roles)
                .setWorkspaces(workspaces);
    }

    public Optional<User> toUser(IUserPersistedDto userDto) {
        return userRepository.findById(userDto.getId());
    }
}
