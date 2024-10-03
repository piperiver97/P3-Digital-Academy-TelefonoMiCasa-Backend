package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.dtos.UserRegistrationDTO;
import com.factoriaf5.telefono_micasa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private UserService userService;

 @PostMapping("/client")
public ResponseEntity<Map<String, String>> registerClient(
    @RequestBody UserRegistrationDTO userRegistrationDTO) {

    try {
        userService.registerClient(userRegistrationDTO.getUsername(), userRegistrationDTO.getEncryptedPassword());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Client created successfully! Now create a new password");
        response.put("username", userRegistrationDTO.getUsername());

        return ResponseEntity.status(201).body(response);

    } catch (Exception e) {
        return ResponseEntity.status(400).body(Collections.singletonMap("error", "Error creating client: " + e.getMessage()));
    }
}
}
