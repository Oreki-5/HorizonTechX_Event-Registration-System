package com.Oreki5.EventRegistration_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Config.JwtService;
import com.Oreki5.EventRegistration_Backend.Models.Users;
import com.Oreki5.EventRegistration_Backend.Repo.UsersRepo;

@Service
public class UserService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsersRepo usersRepo;

    public String verifyUser(Users user) throws Exception {
        return jwtService.generateToken(user);
        // jwt logic goes here
    }

    // Need to add duplicate username validation
    public boolean saveUser(Users user) {
        if (user.getId() > 0) {
            usersRepo.saveAndFlush(user);
            return true;
        } else {
            try {
                usersRepo.findByUsername(user.getUsername()).getUsername();
                return false;

            } catch (NullPointerException e) {
                user.setPassword(encodePassword(user.getPassword()));
                usersRepo.saveAndFlush(user);
                return true;
            }
        }

    }

    public String encodePassword(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        return encoder.encode(pass);
    }

    public void deleteUser(int id) {
        usersRepo.deleteById(id);
    }

    // test service
    public List<Users> getAll() {
        return usersRepo.findAll();
    }

}
