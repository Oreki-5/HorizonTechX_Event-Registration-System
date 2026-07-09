package com.Oreki5.EventRegistration_Backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Oreki5.EventRegistration_Backend.Models.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
    

}
