package com.factoriaf5.telefono_micasa.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class RoleTest {

    @Test
    void testCanEqual() {
        Role role1 = new Role();
        Role role2 = new Role();
        assertTrue(role1.canEqual(role2));
    }

    @Test
    void testEquals() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ROLE_USER");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("ROLE_USER");

        assertEquals(role1, role2);
    }

    @Test
    void testGetId() {
        Role role = new Role();
        role.setId(1L);
        assertEquals(1L, role.getId());
    }

    @Test
    void testGetName() {
        Role role = new Role();
        role.setName("ROLE_USER");
        assertEquals("ROLE_USER", role.getName());
    }

    @Test
    void testGetUsers() {
        Role role = new Role();
        
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        role.setUsers(users);
        assertEquals(users, role.getUsers());
    }

    @Test
    void testHashCode() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ROLE_USER");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("ROLE_USER");

        assertEquals(role1.hashCode(), role2.hashCode());
    }

    @Test
    void testSetId() {
        Role role = new Role();
        role.setId(2L);
        assertEquals(2L, role.getId());
    }

    @Test
    void testSetName() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", role.getName());
    }

    @Test
    void testSetUsers() {
        Role role = new Role();
        
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");

        Set<User> users = new HashSet<>();
        users.add(user1);

        role.setUsers(users);
        assertEquals(users, role.getUsers());
    }

    @Test
    void testToString() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
  
        String expectedString = "Role(id=1, name=ROLE_USER, users=null)";
        assertEquals(expectedString, role.toString());
    }
}
