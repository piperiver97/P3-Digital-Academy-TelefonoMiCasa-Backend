package com.factoriaf5.telefono_micasa.dtos;

public class UserRegistrationDTO {
    
    private String username;
    private String encryptedPassword;

    // Constructor vacío
    public UserRegistrationDTO() {}

    // Constructor con parámetros
    public UserRegistrationDTO(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
