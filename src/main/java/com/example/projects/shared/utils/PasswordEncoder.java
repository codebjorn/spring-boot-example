package com.example.projects.shared.utils;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends Argon2PasswordEncoder {
}
