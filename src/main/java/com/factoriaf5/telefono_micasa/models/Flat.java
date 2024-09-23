package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FLAT")
public class Flat extends Property{
    private Integer room;
    private Integer bathroom;
    private boolean HasElevator;

    public Flat(){

    }


    public Flat(Long id, double price, String description, String address, double area, String action, Integer room,
            Integer bathroom, boolean hasElevator) {
        super(id, price, description, address, area, action);
        this.room = room;
        this.bathroom = bathroom;
        HasElevator = hasElevator;
    }


    public Integer getRoom() {
        return room;
    }


    public void setRoom(Integer room) {
        this.room = room;
    }


    public Integer getBathroom() {
        return bathroom;
    }


    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }


    public boolean isHasElevator() {
        return HasElevator;
    }


    public void setHasElevator(boolean hasElevator) {
        HasElevator = hasElevator;
    }

    
  

    
}
