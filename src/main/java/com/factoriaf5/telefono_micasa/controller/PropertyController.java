package com.factoriaf5.telefono_micasa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.services.PropertyService;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/search/action_type")
    public List<Property> getPropertiesByAction(@RequestParam String action) {
        return propertyService.getPropertiesByAction(action);
    }

    @GetMapping("/search/filter")
    public List<Property> filterProperties(@RequestParam String type, @RequestParam String action) {
        return propertyService.filterProperties(type, action);
    }

    @PostMapping("/property")
    public ResponseEntity<Property> createProperty(@RequestBody PropertyDTO propertyDTO) {
        Property property;
        
        try {
            switch (propertyDTO.getType().toLowerCase()) {
                case "house":
                    property = propertyService.createHouse(propertyDTO);
                    break;

                case "flat":
                    property = propertyService.createFlat(propertyDTO);
                    break;

                case "garage":
                    property = propertyService.createGarage(propertyDTO);
                    break;

                case "storageroom":
                    property = propertyService.createStorageRoom(propertyDTO);
                    break;

                default:
                    return ResponseEntity.badRequest().body(null);
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

        Property savedProperty = propertyService.createProperty(property);
        return ResponseEntity.ok(savedProperty);
    }
}
