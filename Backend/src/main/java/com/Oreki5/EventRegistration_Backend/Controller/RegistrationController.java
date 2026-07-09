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
public class RegistrationController {

    @Autowired
    private RegistrationService regService;
    @Autowired
    private EventService eventService;

    // Registration Based Endpoints

    // Get User specific Registrations
    @GetMapping("/registrations/{id}")
    public List<Registrations> getRegistrationsById(@PathVariable int id) {
        regService.getRegistrationById(id);
        return null;
    }

    // Create a new Registration for User
    @PostMapping("/registerations")
    public void createRegistration(@RequestBody Registrations registrations) {
        regService.saveRegistration(registrations);
    }

    // Update an existing Registration of User
    @PutMapping("/registrations")
    public void updateRegistration(@RequestBody Registrations registrations) {
        regService.saveRegistration(registrations);
    }

    // Delete an existing Registration based on its ID
    @DeleteMapping("/registrations/{id}")
    public void deleteRegistration(@PathVariable int id) {
        regService.deleteRegsitration(id);
    }


    // To Show all available events for user to register
    @GetMapping("/events")
    public List<Events> getAllAvailableEvents(){
        return eventService.getAllActive();
        
    }

}
