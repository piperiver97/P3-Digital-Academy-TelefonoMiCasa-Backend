package com.factoriaf5.telefono_micasa.services;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;  // Cambiar aquí al paquete correcto
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createSalesman(String username, String encryptedPassword) {
        Role salesmanRole = roleService.findByName("ROLE_SALESMAN");

        if (salesmanRole == null) {
            throw new IllegalArgumentException("Role not found");
        }

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User(username, encryptedPassword);
        user.setRoles(Collections.singleton(salesmanRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllSalesmen() {
        return userRepository.findAll();
    }
}
