package com.factoriaf5.telefono_micasa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factoriaf5.telefono_micasa.models.Properti;
import com.factoriaf5.telefono_micasa.repositories.PropertiRepository;

@Service
public class PropertiService {
    
 @Autowired
  private PropertiRepository propertiRepository;


 public List<Properti> getPropertiesByAction(String action){
    return propertiRepository.findByAction(action);
 }

}
