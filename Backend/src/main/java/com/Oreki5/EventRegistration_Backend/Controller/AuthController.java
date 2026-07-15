package com.Oreki5.EventRegistration_Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/auth")
public class AuthController {
    // Endpoints for authentication and updating users

    @Autowired
    private UserService userService;

    // Register a User
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Users user) {
        return userService.saveUser(user)? new ResponseEntity<>("User Created Successfully",HttpStatus.OK) : new ResponseEntity<>("Username already used!",HttpStatus.CONFLICT);
    }

    // testing purpose endpoint
    // get all users
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> verifyUser(@RequestBody Users user) throws Exception {
        String token = userService.verifyUser(user);
        System.out.println("login req");
        return new ResponseEntity<>("Token: "+token, HttpStatus.OK);
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
