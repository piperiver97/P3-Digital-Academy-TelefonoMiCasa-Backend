package com.factoriaf5.telefono_micasa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
