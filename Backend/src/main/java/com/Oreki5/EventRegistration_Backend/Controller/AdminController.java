package com.Oreki5.EventRegistration_Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.EventRegistration_Backend.Models.Events;
import com.Oreki5.EventRegistration_Backend.Models.Registrations;
import com.Oreki5.EventRegistration_Backend.Service.EventService;
import com.Oreki5.EventRegistration_Backend.Service.RegistrationService;

@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    private EventService eventService;
    @Autowired
    private RegistrationService regService;

    //
    @PostMapping("/events")
    public void createEvent(@RequestBody Events event) {
        eventService.createEvent(event);
    }

    @GetMapping("/events/{user_id}")
    public List<Events> getEventsByUser(@PathVariable int id) {
        return eventService.getByUser(id);
    }

    @GetMapping("/registrations/{event_id}")
    public List<Registrations> getRegistrationsByEvent(@PathVariable int id) {
        return regService.getByEvent(id);
    }

    @PutMapping("/events")
    public void updateEvent(@RequestBody Events event) {
        eventService.updateEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

}
