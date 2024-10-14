package com.factoriaf5.telefono_micasa.factories;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.Garage;
import com.factoriaf5.telefono_micasa.models.Property;

public class GarageFactory extends PropertyFactory {
    @Override
    public Property createProperty(PropertyDTO propertyDTO) {
        Garage garage = new Garage();
        garage.setPrice(propertyDTO.getPrice());
        garage.setAddress(propertyDTO.getAddress());
        garage.setDescription(propertyDTO.getDescription());
        garage.setAction(propertyDTO.getAction());
        return garage;
    }
}

