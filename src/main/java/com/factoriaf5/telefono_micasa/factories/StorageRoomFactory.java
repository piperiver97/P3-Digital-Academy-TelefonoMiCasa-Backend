package com.factoriaf5.telefono_micasa.factories;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.StorageRoom;
import com.factoriaf5.telefono_micasa.models.Property;

public class StorageRoomFactory extends PropertyFactory {
    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        StorageRoom storageRoom = new StorageRoom();
        storageRoom.setPrice(propertyDTO.getPrice());
        storageRoom.setArea(propertyDTO.getArea());
        storageRoom.setAddress(propertyDTO.getAddress());
        storageRoom.setDescription(propertyDTO.getDescription());
        storageRoom.setAction(propertyDTO.getAction());
        return storageRoom;
    }
}

