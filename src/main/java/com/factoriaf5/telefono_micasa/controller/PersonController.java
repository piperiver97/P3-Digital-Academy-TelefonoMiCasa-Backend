package com.factoriaf5.telefono_micasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.factoriaf5.telefono_micasa.models.PersonForm;
import com.factoriaf5.telefono_micasa.services.PersonService;

@RestController
@RequestMapping("${api-endpoint}/personform")
@CrossOrigin(origins = "http://localhost:5173") // Permitir solicitudes desde tu frontend
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonForm> crearPersona(@RequestBody PersonForm persona) {
        PersonForm nuevaPersona = personService.crearPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }
}
