package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SalesmanController {

    @Autowired
    private UserService userService;

    @PostMapping("/salesmen")
    public ResponseEntity<Map<String, String>> createSalesman(
        @RequestHeader("username") String username,
        @RequestHeader("password") String encryptedPassword) {

        try {

            userService.createSalesman(username, encryptedPassword);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Salesman created successfully! Now create a new password");
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

    // Endpoint para actualizar la contraseña de un vendedor con PUT
    @PutMapping("/salesmen/update-password")
    public ResponseEntity<Map<String, String>> updateSalesmanPassword(
        @RequestHeader("encryptedPassword") String encryptedPassword,
        Authentication authentication) {
        try {
            String username = authentication.getName();
            userService.updateUserPasswordByUsername(username, encryptedPassword);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Password updated successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Error updating password: " + e.getMessage()));
        }
    }
}
