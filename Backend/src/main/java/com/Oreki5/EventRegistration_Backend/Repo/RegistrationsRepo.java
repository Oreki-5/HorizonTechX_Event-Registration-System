package com.Oreki5.EventRegistration_Backend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Oreki5.EventRegistration_Backend.Models.Registrations;

@Repository
public interface RegistrationsRepo extends JpaRepository<Registrations, Integer> {
    List<Registrations> findAllByUserId(int user_id);

    List<Registrations> findAllByEventId(int event_id);

    List<Registrations> findAllByUserIdAndEventId(int user_id, int event_id);

}
