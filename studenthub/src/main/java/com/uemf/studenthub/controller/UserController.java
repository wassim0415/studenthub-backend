package com.uemf.studenthub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uemf.studenthub.model.User;
import com.uemf.studenthub.service.UserService;

@RestController
@RequestMapping("/api/users") // URL dédiée aux utilisateurs
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint pour lire les utilisateurs (GET)
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // Endpoint pour créer un utilisateur (POST)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}