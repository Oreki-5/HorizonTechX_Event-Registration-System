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

    public boolean saveRegistration(Registrations registrations) {
        // If it is an update request
        if (registrations.getId() > 0) {
            registrationsRepo.saveAndFlush(registrations);
            return true;
        }
        List<Registrations> existing = registrationsRepo.findAllByUserId(registrations.getUserId());
        if (existing.isEmpty()) {
            registrationsRepo.saveAndFlush(registrations);
            return true;
        }

        else
            return false;

    }

    public void deleteRegsitration(int id) {
        registrationsRepo.deleteById(id);
    }

    public List<Registrations> getRegistrationByUserId(int id) {
        List<Registrations> reg = registrationsRepo.findAllByUserId(id);
        // registrationsRepo.findAll();
        return reg;
    }

    public List<Registrations> getByEvent(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEvent'");
    }

}
