package com.Oreki5.EventRegistration_Backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;
import com.Oreki5.EventRegistration_Backend.Repo.EventsRepo;

@Service
public class EventService {

    @Autowired
    private EventsRepo eventsRepo;

    public List<EventsResponse> getAllActive() {
        return eventsRepo.findAllByStatus("active");
    }

    // Need to add in the design plan
    public List<EventsResponse> getAllInactive() {
        return eventsRepo.findAllByStatus("inactive");
    }

    public boolean saveEvent(Events event) {
        if (event.getId() > 0) {
            eventsRepo.saveAndFlush(event);
            return true;
        } else {
            try {
                eventsRepo.findByName(event.getName()).getName();
                return false;

            } catch (NullPointerException e) {
                eventsRepo.saveAndFlush(event);
                return true;
            }
        }
    }

    public List<EventsResponse> getByUser(int id) {
        return eventsRepo.findAllByUserId(id);
    }

    public boolean deleteEvent(int id) {
        Optional<Events> event = eventsRepo.findById(id);
        if (event.isPresent()) {
            Events eventObj = event.get();
            eventObj.setStatus("inactive");
            eventsRepo.saveAndFlush(eventObj);
            return true;
        } else
            return false;

    }

    public boolean restoreEvent(int id) {
        Optional<Events> event = eventsRepo.findById(id);
        if (event.isPresent()) {
            Events eventObj = event.get();
            eventObj.setStatus("active");
            eventsRepo.saveAndFlush(eventObj);
            return true;
        } else
            return false;

    }

}
