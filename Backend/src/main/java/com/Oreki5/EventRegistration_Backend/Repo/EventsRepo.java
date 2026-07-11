package com.Oreki5.EventRegistration_Backend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer> {

    /*
     * The order of columns in the @query matters ,
     * because at first it mapped name to descrption cause I selected the desciption
     * column first after the id in query
     * and in the Event Response object, name column was the first column defined after id
     */
    @Query(nativeQuery = true, value = "SELECT id,name,description,status,user_id FROM events e WHERE e.status = :stat")
    List<EventsResponse> findAllByStatus(@Param("stat") String status);

    // Learnt how to use dynamic where clause in native query in @Query
    @Query(nativeQuery = true, value = "SELECT id,name,description,status FROM events e WHERE user_id = :uid")
    List<EventsResponse> findAllByUserId(@Param("uid") int id);
}
