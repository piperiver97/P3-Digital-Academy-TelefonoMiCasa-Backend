package com.factoriaf5.telefono_micasa.services;

import com.factoriaf5.telefono_micasa.facades.encryptations.Base64Encoder;
import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Base64Encoder base64Encoder;

    public void createSalesman(String username, String encryptedPassword) {
        Role salesmanRole = roleService.findByName("ROLE_SALESMAN");

        if (salesmanRole == null) {
            throw new IllegalArgumentException("Role not found");
        }

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        String decryptedPassword = base64Encoder.decode(encryptedPassword);

        User user = new User(username, decryptedPassword);
        user.setRoles(Collections.singleton(salesmanRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllSalesmen() {
        Role salesmanRole = roleService.findByName("ROLE_SALESMAN");
        if (salesmanRole == null) {
            throw new IllegalArgumentException("Salesmman rol not found");
        }
        return userRepository.findByRolesIn(Collections.singletonList(salesmanRole));
    }

     // Método para actualizar la contraseña de un usuario por ID
     public void updateUserPassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
       
        String decryptedPassword = base64Encoder.decode(newPassword);
       
        user.setPassword(passwordEncoder.encode(decryptedPassword));
        userRepository.save(user);
    }
    // Método para actualizar la contraseña de un usuario por nombre de usuario
    public void updateUserPasswordByUsername(String username, String newPassword) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        String decryptedPassword = base64Encoder.decode(newPassword);
       
        user.setPassword(passwordEncoder.encode(decryptedPassword));
        userRepository.save(user);
    }
    public void registerClient(String username, String encryptedPassword) {
        Role clientRole = roleService.findByName("ROLE_USER");

        if (clientRole == null) {
            throw new IllegalArgumentException("Role not found");
        }

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        String decryptedPassword = base64Encoder.decode(encryptedPassword);

        User user = new User(username, decryptedPassword);
        user.setRoles(Collections.singleton(clientRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}