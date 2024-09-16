package com.factoriaf5.telefono_micasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class PropertiController {

    @Autowired
    private PropertiRepository PropertiRepository;

    @GetMapping("/action_type")
    public List <Properti> getPropertiesByAction(@RequestParam String type){
        return PropertiRepository.findByAction(Action);
    }

    
}
