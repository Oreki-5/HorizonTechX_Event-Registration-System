package com.Oreki5.EventRegistration_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Models.Registrations;
import com.Oreki5.EventRegistration_Backend.Repo.EventsRepo;
import com.Oreki5.EventRegistration_Backend.Repo.RegistrationsRepo;
import com.Oreki5.EventRegistration_Backend.Repo.UsersRepo;

@Service
public class RegistrationService {
    @Autowired
    private EventsRepo eventsRepo;

    @Autowired
    private UsersRepo usersRepo;
    
    @Autowired 
    private RegistrationsRepo registrationsRepo;

    public void deleteRegsitration(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRegsitration'");
    }

    public void saveRegistration(Registrations registrations) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveRegistration'");
    }


    public void getRegistrationById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRegistrationById'");
    }

    public List<Registrations> getByEvent(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEvent'");
    }

    
}
