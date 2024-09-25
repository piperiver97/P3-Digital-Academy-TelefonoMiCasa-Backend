package com.factoriaf5.telefono_micasa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.Flat;
import com.factoriaf5.telefono_micasa.models.Garage;
import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.models.StorageRoom;
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

    // Método para crear una propiedad
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Lógica para crear una casa
    public House createHouse(PropertyDTO propertyDTO) {
        House house = new House();
        house.setPrice(propertyDTO.getPrice());
        house.setRoom(propertyDTO.getRoom());
        house.setBathroom(propertyDTO.getBathroom());
        house.setFloors(propertyDTO.getFloors());

        if (propertyDTO.getArea() != null) {
            house.setArea(propertyDTO.getArea());
        } else {
            throw new IllegalArgumentException("El área es requerida");
        }

        house.setAddress(propertyDTO.getAddress());
        house.setDescription(propertyDTO.getDescription());
        return house;
    }

    // Lógica para crear un apartamento
    public Flat createFlat(PropertyDTO propertyDTO) {
        Flat flat = new Flat();
        flat.setPrice(propertyDTO.getPrice());
        flat.setRoom(propertyDTO.getRoom());
        flat.setBathroom(propertyDTO.getBathroom());
        flat.setFloors(propertyDTO.getFloors());
        flat.setHasElevator(propertyDTO.getHasElevator());

        if (propertyDTO.getArea() != null) {
            flat.setArea(propertyDTO.getArea());
        } else {
            throw new IllegalArgumentException("El área es requerida");
        }

        flat.setAddress(propertyDTO.getAddress());
        flat.setDescription(propertyDTO.getDescription());
        return flat;
    }

    // Lógica para crear un garaje
    public Garage createGarage(PropertyDTO propertyDTO) {
        Garage garage = new Garage();
        garage.setPrice(propertyDTO.getPrice());
        garage.setAddress(propertyDTO.getAddress());
        garage.setDescription(propertyDTO.getDescription());
        return garage;
    }

    // Lógica para crear un trastero
    public StorageRoom createStorageRoom(PropertyDTO propertyDTO) {
        StorageRoom storageRoom = new StorageRoom();
        storageRoom.setPrice(propertyDTO.getPrice());

        if (propertyDTO.getArea() != null) {
            storageRoom.setArea(propertyDTO.getArea());
        } else {
            throw new IllegalArgumentException("El área es requerida");
        }

        storageRoom.setAddress(propertyDTO.getAddress());
        storageRoom.setDescription(propertyDTO.getDescription());
        return storageRoom;
    }
}
