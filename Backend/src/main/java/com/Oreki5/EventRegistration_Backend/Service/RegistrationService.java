package com.Oreki5.EventRegistration_Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.EventRegistration_Backend.Models.Registrations;
import com.Oreki5.EventRegistration_Backend.Repo.RegistrationsRepo;

@Service
public class RegistrationService {


    @Autowired
    private RegistrationsRepo registrationsRepo;

    public boolean saveRegistration(Registrations registrations) {
        // If it is an update request
        if (registrations.getId() > 0) {
            registrationsRepo.saveAndFlush(registrations);
            return true;
        }
        List<Registrations> userCheck = registrationsRepo.findAllByUserIdAndEventId(registrations.getUserId(), registrations.getEventId());
        if (userCheck.isEmpty()) {
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
        return registrationsRepo.findAllByEventId(id);
    }

}
