package com.rituraj.salon.salonbooking.controller;

import com.rituraj.salon.salonbooking.model.UserEntity;
import com.rituraj.salon.salonbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Signup
    @PostMapping("/signup")
    public UserEntity registerUser(@RequestBody UserEntity req) {
        return userService.saveUser(req);
    }

    // Login with email/password
    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity req) {
        return userService.loginUser(req.getEmail(), req.getPassword());
    }

    // Login with Google
    @PostMapping("/google-login")
    public UserEntity googleLogin(@RequestBody Map<String, String> body) {
        String idToken = body.get("token");
        return userService.loginWithGoogle(idToken);
    }
}
