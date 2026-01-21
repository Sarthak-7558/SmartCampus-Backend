package com.sarthak.service;

import com.sarthak.entity.Role;
import com.sarthak.entity.User;
import com.sarthak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllStaff() {
        return userRepository.findByRole(Role.STAFF);
    }
}
