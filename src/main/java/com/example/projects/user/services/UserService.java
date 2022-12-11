package com.example.projects.user.services;

import com.example.projects.shared.utils.PasswordEncoder;
import com.example.projects.user.entities.User;
import com.example.projects.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return Streamable.of(userRepository.findAll()).toList();
    }

    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User create(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        return userRepository.save(user.setPassword(hashedPassword));
    }

    public User update(Long id, User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
