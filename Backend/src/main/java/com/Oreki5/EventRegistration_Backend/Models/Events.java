package com.Oreki5.EventRegistration_Backend.Models;

import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @ColumnDefault("active")
    private String status;


    @Column
    private int userId;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "eventId", referencedColumnName = "id")
    private Set<Registrations> registrations;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Registrations> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registrations> registrations) {
        this.registrations = registrations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
}
