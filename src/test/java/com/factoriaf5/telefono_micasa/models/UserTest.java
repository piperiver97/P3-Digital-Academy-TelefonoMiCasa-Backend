package com.factoriaf5.telefono_micasa.models;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testGetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("secretPassword");
        assertEquals("secretPassword", user.getPassword());
    }

    @Test
    void testGetRoles() {
        User user = new User();
        
        Role roleUser = new Role();
        Role roleAdmin = new Role();
        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        roles.add(roleAdmin);
        
        user.setRoles(roles);
        assertEquals(roles, user.getRoles());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testSetId() {
        User user = new User();
        user.setId(2L);
        assertEquals(2L, user.getId());
    }

    @Test
    void testSetPassword() {
        User user = new User();
        user.setPassword("newSecretPassword");
        assertEquals("newSecretPassword", user.getPassword());
    }

    @Test
    void testSetRoles() {
        User user = new User();
        
        Role roleUser = new Role();
        Set<Role> newRoles = new HashSet<>();
        newRoles.add(roleUser);
        
        user.setRoles(newRoles);
        assertEquals(newRoles, user.getRoles());
    }

    @Test
    void testSetUsername() {
        User user = new User();
        user.setUsername("newUser");
        assertEquals("newUser", user.getUsername());
    }
}
