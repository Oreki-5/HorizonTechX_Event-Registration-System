package com.Oreki5.EventRegistration_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Models.Users;
import com.Oreki5.EventRegistration_Backend.Repo.UsersRepo;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    public void verifyUser(Users user) {
        // jwt logic goes here
    }

    // Need to add duplicate username validation 
    public void saveUser(Users user) {
        usersRepo.saveAndFlush(user);
    }

    public void deleteUser(int id) {
        usersRepo.deleteById(id);
    }

    // test service
    public List<Users> getAll(){
        return usersRepo.findAll();
    }

}
