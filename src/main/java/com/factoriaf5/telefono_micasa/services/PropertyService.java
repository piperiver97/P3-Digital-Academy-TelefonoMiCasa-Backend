package com.factoriaf5.telefono_micasa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.factories.FlatFactory;
import com.factoriaf5.telefono_micasa.factories.GarageFactory;
import com.factoriaf5.telefono_micasa.factories.HouseFactory;
import com.factoriaf5.telefono_micasa.factories.PropertyFactory;
import com.factoriaf5.telefono_micasa.factories.StorageRoomFactory;
import com.factoriaf5.telefono_micasa.models.Flat;

import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Property;

import com.factoriaf5.telefono_micasa.repositories.PropertyRepository;

@Service
public class PropertyService {
    
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getPropertiesByAction(String action){
        return propertyRepository.findByAction(action);
    }

    public List<Property> filterProperties(String propertyType, String action) {
        Class<?> typeClass;
        switch (propertyType.toUpperCase()) {
            case "HOUSE":
                typeClass = House.class;
                break;
            case "FLAT":
                typeClass = Flat.class;
                break;
            default:
                throw new IllegalArgumentException("Tipo de propiedad no válido");
        }
        return propertyRepository.filterByActionAndType(action, typeClass);
    }

    

     public Property createProperty(PropertyDTO propertyDTO) {
        PropertyFactory factory;
        
        switch (propertyDTO.getType().toLowerCase()) {
            case "house":
                factory = new HouseFactory();
                break;
            case "flat":
                factory = new FlatFactory();
                break;
            case "garage":
                factory = new GarageFactory(); // Implementar GarageFactory
                break;
            case "storageroom":
                factory = new StorageRoomFactory(); // Implementar StorageRoomFactory
                break;
            default:
                throw new IllegalArgumentException("Tipo de propiedad no válido");
        }
        
        Property property = factory.createProperty(propertyDTO);
        return propertyRepository.save(property);
    }
}
