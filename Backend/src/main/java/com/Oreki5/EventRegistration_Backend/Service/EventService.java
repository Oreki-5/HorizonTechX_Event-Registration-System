package com.Oreki5.EventRegistration_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;
import com.Oreki5.EventRegistration_Backend.Repo.EventsRepo;
import com.Oreki5.EventRegistration_Backend.Repo.RegistrationsRepo;
import com.Oreki5.EventRegistration_Backend.Repo.UsersRepo;

@Service
public class EventService {

    @Autowired
    private EventsRepo eventsRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private RegistrationsRepo registrationsRepo;

    public List<EventsResponse> getAllActive() {
        return eventsRepo.findAllActive();
    }

    public void createEvent(Events event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEvent'");
    }

    public List<Events> getByUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByUser'");
    }

    public void updateEvent(Events event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvent'");
    }

    public void deleteEvent(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvent'");
    }

}
