package com.sarthak.service;

import com.sarthak.dto.RegisterRequest;
import com.sarthak.entity.User;
import com.sarthak.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER USER (JSON -> DTO -> ENTITY)
    public User registerUser(RegisterRequest request) {

        // optional safety check
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // bcrypt
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}
