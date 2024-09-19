package com.factoriaf5.telefono_micasa.services;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.repositories.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByName() {
        String roleName = "USER";
        Role expectedRole = new Role();
        expectedRole.setName(roleName);

        when(roleRepository.findByName(roleName)).thenReturn(expectedRole);

        Role actualRole = roleService.findByName(roleName);

        assertEquals(expectedRole, actualRole);
    }
}
