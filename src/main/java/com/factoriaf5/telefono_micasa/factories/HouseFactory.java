package com.factoriaf5.telefono_micasa.factories;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Property;

public class HouseFactory extends PropertyFactory {
    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        House house = new House();
        house.setPrice(propertyDTO.getPrice());
        house.setAddress(propertyDTO.getAddress());
        house.setDescription(propertyDTO.getDescription());
        house.setArea(propertyDTO.getArea());
        house.setAction(propertyDTO.getAction());
        house.setRoom(propertyDTO.getRoom());
        house.setBathroom(propertyDTO.getBathroom());
        house.setFloors(propertyDTO.getFloors());
        return house;
    }
}

