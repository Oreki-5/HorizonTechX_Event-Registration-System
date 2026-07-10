package com.Oreki5.EventRegistration_Backend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer>{

    @Query(nativeQuery=true ,value="SELECT id,description,name,status FROM events e WHERE e.status = 'active'")
    List<EventsResponse> findAllActive();
}
