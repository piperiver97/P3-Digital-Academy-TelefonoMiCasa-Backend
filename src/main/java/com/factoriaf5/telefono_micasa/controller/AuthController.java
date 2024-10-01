package com.factoriaf5.telefono_micasa.controller;

import java.util.HashMap;
import java.util.Map;

import com.factoriaf5.telefono_micasa.services.UserService;
import com.factoriaf5.telefono_micasa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @Autowired
    private UserService userService;  // Inyectamos el servicio de usuario

    @GetMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login() {
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        // Obtenemos el usuario autenticado desde el servicio
        String username = auth.getName();
        User user = userService.findByUsername(username);  // Método para buscar el usuario

        // Creamos el JSON de respuesta como Map<String, String>
        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("username", username);
        json.put("roles", auth.getAuthorities().iterator().next().toString());

        // Añadimos el estado del cambio de contraseña como String ("true" o "false")
        json.put("passwordChanged", String.valueOf(user.isPasswordChanged()));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
