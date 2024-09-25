package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STORAGEROOM")
public class StorageRoom extends Property {

    public StorageRoom() {}

    public StorageRoom(Long id, double price, String description, String address, double area, String action) {
        super(id, price, description, address, area, action);
    }

  
}
