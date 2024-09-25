package com.factoriaf5.telefono_micasa.factories;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.Flat;
import com.factoriaf5.telefono_micasa.models.Property;

public class FlatFactory extends PropertyFactory {
    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        Flat flat = new Flat();
        flat.setPrice(propertyDTO.getPrice());
        flat.setAddress(propertyDTO.getAddress());
        flat.setDescription(propertyDTO.getDescription());
        flat.setArea(propertyDTO.getArea());
        flat.setAction(propertyDTO.getAction());
        flat.setRoom(propertyDTO.getRoom());
        flat.setBathroom(propertyDTO.getBathroom());
        flat.setFloors(propertyDTO.getFloors());
        flat.setHasElevator(propertyDTO.getHasElevator());
        return flat;
    }
}

