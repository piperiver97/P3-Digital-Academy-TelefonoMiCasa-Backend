package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.services.RoleService;
import com.factoriaf5.telefono_micasa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SalesmanRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/salesmen")
    public ResponseEntity<Map<String, String>> createSalesman(
        @RequestHeader("username") String username,
        @RequestHeader("password") String password) {
        
        try {
            Role salesmanRole = roleService.findByName("ROLE_SALESMAN");

            if (salesmanRole == null) {
                return ResponseEntity.status(500).body(Collections.singletonMap("error", "Role not found"));
            }

            User user = new User(username, password);
            user.setRoles(Collections.singleton(salesmanRole));

            userService.registerUser(user);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Salesman created successfully!");
            response.put("username", username);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Error creating salesman: " + e.getMessage()));
        }
    }

    @GetMapping("/salesmen")
    public List<User> getAllSalesmen() {
        return userService.getAllSalesmen();
    }
}
