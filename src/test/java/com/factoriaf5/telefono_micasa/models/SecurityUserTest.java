package com.factoriaf5.telefono_micasa.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUserTest {

    private User mockUser;
    private SecurityUser securityUser;
    private Set<Role> roles;

    @BeforeEach
    void setUp() {
        mockUser = mock(User.class);
        roles = new HashSet<>();

        Role role1 = new Role();
        role1.setName("ROLE_USER");
        roles.add(role1);

        Role role2 = new Role();
        role2.setName("ROLE_ADMIN");
        roles.add(role2);

        when(mockUser.getRoles()).thenReturn(roles);
        when(mockUser.getPassword()).thenReturn("password123");
        when(mockUser.getUsername()).thenReturn("user1");

        securityUser = new SecurityUser(mockUser);
    }

    @Test
    void testGetAuthorities() {
        var authorities = securityUser.getAuthorities();

        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
        assertEquals(2, authorities.size());
    }

    @Test
    void testGetPassword() {
        assertEquals("password123", securityUser.getPassword());
    }

    @Test
    void testGetUsername() {
        assertEquals("user1", securityUser.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(securityUser.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(securityUser.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(securityUser.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertTrue(securityUser.isEnabled());
    }
}
