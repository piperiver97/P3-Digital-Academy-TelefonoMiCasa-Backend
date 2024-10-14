package com.factoriaf5.telefono_micasa.models;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String username;
    private String password;
    // Campo para indicar si el usuario ha cambiado su contraseña
    @Column(name = "password_changed", nullable = false)
    private boolean passwordChanged = false;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_users",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;

    @OneToOne( fetch =FetchType.EAGER)
    @JoinTable(name = "users_zones", 
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id_user") },
        inverseJoinColumns = {@JoinColumn(name = "zone_id", referencedColumnName = "id")})
     private Zone zone;

    // Constructor vacío
    public User() {}
    // Constructor con parámetros
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.passwordChanged = false; // Inicialización
    }
    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles; 	
    }
    // Getter y Setter para el campo passwordChanged
    public boolean isPasswordChanged() {
        return passwordChanged;
    }
    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}