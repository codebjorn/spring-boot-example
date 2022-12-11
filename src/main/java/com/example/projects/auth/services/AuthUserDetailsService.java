package com.example.projects.auth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.projects.user.entities.Role;
import com.example.projects.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.projects.user.entities.User user = repository.findByUsername(username).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<Role> roles = user.getRoles();

        List<GrantedAuthority> grantedAuthorities = roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
