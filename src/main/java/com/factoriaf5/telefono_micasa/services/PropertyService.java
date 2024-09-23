package com.factoriaf5.telefono_micasa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.repositories.PropertyRepository;

@Service
public class PropertyService {
    
 @Autowired
  private PropertyRepository propertyRepository;


 public List<Property> getPropertiesByAction(String action){
    return propertyRepository.findByAction(action);
 }

}
