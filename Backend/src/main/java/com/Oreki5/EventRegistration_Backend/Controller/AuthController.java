package com.Oreki5.EventRegistration_Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.EventRegistration_Backend.Models.Users;
import com.Oreki5.EventRegistration_Backend.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // Endpoints for authentication and updating users

    @Autowired
    private UserService userService;

    // Register a User
    @PostMapping("/register")
    public void createUser(@RequestBody Users user) {
        userService.saveUser(user);
    }

    // testing purpose endpoint
    // get all users
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public void verifyUser(@RequestBody Users user) {
        userService.verifyUser(user);
        System.out.println("login req");
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody Users user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
