package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GARAGE")
public class Garage extends Property {

    public Garage() {}

    public Garage(Long id, double price, String description, String address, double area, String action) {
        super(id, price, description, address, area, action);
    }

}

