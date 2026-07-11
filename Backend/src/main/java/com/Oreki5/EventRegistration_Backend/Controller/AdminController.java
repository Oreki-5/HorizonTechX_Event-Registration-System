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

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;
import com.Oreki5.EventRegistration_Backend.Models.Registrations;
import com.Oreki5.EventRegistration_Backend.Service.EventService;
import com.Oreki5.EventRegistration_Backend.Service.RegistrationService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EventService eventService;

    @Autowired
    private RegistrationService regService;

    // Create an event
    @PostMapping("/events")
    public ResponseEntity<String> createEvent(@RequestBody Events event) {
        return eventService.saveEvent(event)
                ? new ResponseEntity<>("Event Created Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    // Get all the events created by a user
    // tested
    @GetMapping("/events/users/{user_id}")
    public List<EventsResponse> getEventsByUser(@PathVariable int user_id) {
        return eventService.getByUser(user_id);
    }

    // Get All registration records for an event
    // tested
    @GetMapping("/registrations/events/{event_id}")
    public List<Registrations> getRegistrationsByEvent(@PathVariable int event_id) {
        return regService.getByEvent(event_id);
    }

    // Update an existing event
    // tested
    @PutMapping("/events")
    public ResponseEntity<String> updateEvent(@RequestBody Events event) {
        return eventService.saveEvent(event)
                ? new ResponseEntity<>("Event Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    // Delete/disable/de-activate the event
    // tested
    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    // Get all inactive events
    // Need to add in design plan
    // tested
    @GetMapping("/events/inactive")
    public List<EventsResponse> getInactiveEvents() {
        return eventService.getAllInactive();
    }

    // Restorinng a deleted event
    // Need to add in design plan
    // tested
    @PostMapping("/events/restore/{id}")
    public ResponseEntity<String> restoreEvent(@PathVariable int id) {
        return eventService.restoreEvent(id)
                ? new ResponseEntity<>("Event Restored Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
    }

}
