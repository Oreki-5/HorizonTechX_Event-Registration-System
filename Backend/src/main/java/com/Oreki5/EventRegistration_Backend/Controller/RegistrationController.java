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

import com.Oreki5.EventRegistration_Backend.Models.EventsResponse;
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
    @GetMapping("/registrations/users/{id}")
    public List<Registrations> getRegistrationsByUserId(@PathVariable int id) {
        return regService.getRegistrationByUserId(id);

    }

    // Create a new Registration for User
    @PostMapping("/registrations")
    public ResponseEntity<String> createRegistration(@RequestBody Registrations registrations) {
        return regService.saveRegistration(registrations)
                ? new ResponseEntity<>("Registration Created Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Cannot register for same event multiple times", HttpStatus.CONFLICT);
    }

    // Update an existing Registration of User
    @PutMapping("/registrations")
    public ResponseEntity<String> updateRegistration(@RequestBody Registrations registrations) {
        return regService.saveRegistration(registrations)
                ? new ResponseEntity<>("Registration Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Bad Requests", HttpStatus.BAD_REQUEST);
    }

    // Delete an existing Registration based on its ID
    @DeleteMapping("/registrations/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable int id) {
        regService.deleteRegsitration(id);
        return new ResponseEntity<>("Registration Deleted Successfully", HttpStatus.NO_CONTENT);

    }

    // To Show all available events for user to register
    @GetMapping("/events")
    public List<EventsResponse> getAllAvailableEvents() {
        return eventService.getAllActive();

    }

}
