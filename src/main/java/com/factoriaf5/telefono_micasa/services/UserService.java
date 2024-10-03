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

 
   
 /*    public void updateUserPasswordByUsername(String username, String newPassword) {
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
    public void updateSalesmanPassword(String username, String encryptedPassword) {
        updateUserPasswordByUsername(username, encryptedPassword);
    } */

        // Método para actualizar la contraseña de un usuario por nombre de usuario
        public void updateUserPasswordByUsername(String username, String newPassword) {
            User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
            // Verifica si la contraseña ya ha sido cambiada
            if (user.isPasswordChanged()) {
                throw new IllegalArgumentException("La contraseña ya ha sido cambiada una vez.");
            }
            // Desencriptar la nueva contraseña si está encriptada en Base64
            String decryptedPassword = base64Encoder.decode(newPassword);
            // Encriptar la nueva contraseña
            user.setPassword(passwordEncoder.encode(decryptedPassword));
            // Marcar que la contraseña ha sido cambiada
            user.setPasswordChanged(true);
            userRepository.save(user);
        }
        public void updateSalesmanPassword(String username, String encryptedPassword) {
            updateUserPasswordByUsername(username, encryptedPassword);
        }
        // Método para buscar un usuario por su nombre de usuario
        public User findByUsername(String username) {
            return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        }
        // Nuevo método para obtener el estado de cambio de contraseña
        public boolean getPasswordChangeStatus(String username) {
            User user = findByUsername(username);
            return user.isPasswordChanged();
        }
    }
