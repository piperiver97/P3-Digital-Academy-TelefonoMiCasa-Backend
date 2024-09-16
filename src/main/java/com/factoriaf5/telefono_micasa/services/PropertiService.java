package com.factoriaf5.telefono_micasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiService {
    
 @Autowired
  private PropertiRepository propertiRepository;


 public List<Properti> getPropertiesByAction(String action){
    return propertiRepository.findByAction(action);
 }

}
