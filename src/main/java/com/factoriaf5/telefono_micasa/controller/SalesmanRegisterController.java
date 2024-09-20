package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.services.UserService;
import com.factoriaf5.telefono_micasa.facades.encryptations.Base64Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SalesmanRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private Base64Encoder base64Encoder; 

    @PostMapping("/salesmen")
    public ResponseEntity<Map<String, String>> createSalesman(
        @RequestHeader("username") String username,
        @RequestHeader("password") String encryptedPassword) {

        try {
            String decryptedPassword = base64Encoder.decode(encryptedPassword);

            userService.createSalesman(username, decryptedPassword);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Salesman created successfully!");
            response.put("username", username);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Error creating salesman: " + e.getMessage()));
        }
    }

    @GetMapping("/salesmen")
    public ResponseEntity<?> getAllSalesmen() {
        return ResponseEntity.ok(userService.getAllSalesmen());
    }
}
