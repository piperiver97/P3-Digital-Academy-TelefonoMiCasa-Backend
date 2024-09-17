package com.factoriaf5.telefono_micasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.factoriaf5.telefono_micasa.services.UserService;

@RestController
@RequestMapping("/admin")
public class SalesmanRegisterController {

    @Autowired
    private UserService userService;

    public static class SalesmanDTO {
        public String username;
        public String password;
    }

    @PostMapping("/add-salesman")
    public ResponseEntity<String> createSalesman(@RequestBody SalesmanDTO salesmanDTO) {
        try {
            userService.registerUser(salesmanDTO.username, salesmanDTO.password, "ROLE_SALESMAN");
            return ResponseEntity.ok("Salesman created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error creating salesman: " + e.getMessage());
        }
    }
}
