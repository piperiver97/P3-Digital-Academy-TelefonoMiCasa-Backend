package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HOUSE")
public class House extends Property {
    private Integer room;
    private Integer bathroom;

public House(){

}

public House(Long id, double price, String description, String address, double area, String action, Integer room,
        Integer bathroom) {
    super(id, price, description, address, area, action);
    this.room = room;
    this.bathroom = bathroom;
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

    
}