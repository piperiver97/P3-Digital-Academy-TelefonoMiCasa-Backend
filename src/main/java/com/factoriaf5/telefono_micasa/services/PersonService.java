package com.factoriaf5.telefono_micasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factoriaf5.telefono_micasa.models.PersonForm;
import com.factoriaf5.telefono_micasa.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonForm crearPersona(PersonForm persona) {
        return personRepository.save(persona);
    }
}
