package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.services.RoleService;
import com.factoriaf5.telefono_micasa.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/admin")
public class SalesmanRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public static class SalesmanDTO {
        public String username;
        public String password;
    }

    @PostMapping("/add-salesman")
    public ResponseEntity<String> createSalesman(@RequestBody SalesmanDTO salesmanDTO) {
        try {
            // Buscar el rol de 'ROLE_SALESMAN' en la base de datos
            Role salesmanRole = roleService.findByName("ROLE_SALESMAN");

            if (salesmanRole == null) {
                return ResponseEntity.status(500).body("Role not found");
            }

            User user = new User(salesmanDTO.username, salesmanDTO.password);
            user.setRoles(Collections.singleton(salesmanRole)); // Asignar el rol

            userService.registerUser(user);
            return ResponseEntity.ok("Salesman created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error creating salesman: " + e.getMessage());
        }
    }
}
