package com.Oreki5.EventRegistration_Backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Oreki5.EventRegistration_Backend.Models.Registrations;

@Repository 
public interface RegistrationsRepo extends JpaRepository<Registrations, Integer>{

}
