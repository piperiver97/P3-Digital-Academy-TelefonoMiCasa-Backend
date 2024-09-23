package com.factoriaf5.telefono_micasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.services.PropertyService;

@RestController
@RequestMapping("/api/v1/search")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/action_type")
    public List <Property> getPropertiesByAction(@RequestParam String action){
        return propertyService.getPropertiesByAction(action);
    }

    
}
