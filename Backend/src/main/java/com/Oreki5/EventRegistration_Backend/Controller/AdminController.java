package com.Oreki5.EventRegistration_Backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AdminController {

    // @Autowired
    // private EventService eventService;
    // @Autowired
    // private RegistrationService regService;

    // //
    // @PostMapping("/events")
    // public void createEvent(@RequestBody Events event) {
    //     eventService.createEvent(event);
    // }

    // @GetMapping("/events/{user_id}")
    // public List<Events> getEventsByUser(@PathVariable int id) {
    //     return eventService.getByUser(id);
    // }

    // @GetMapping("/registrations/events/{event_id}")
    // public List<Registrations> getRegistrationsByEvent(@PathVariable int id) {
    //     return regService.getByEvent(id);
    // }

    // @PutMapping("/events")
    // public void updateEvent(@RequestBody Events event) {
    //     eventService.updateEvent(event);
    // }

    // @DeleteMapping("/events/{id}")
    // public void deleteEvent(@PathVariable int id) {
    //     eventService.deleteEvent(id);
    // }

}
