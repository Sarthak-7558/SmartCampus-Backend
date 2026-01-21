package com.sarthak.controller;

import com.sarthak.entity.User;
import com.sarthak.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // ✅ Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🛠️ ADMIN ONLY
    @GetMapping("/staff")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllStaff() {
        return userService.getAllStaff();
    }
}
