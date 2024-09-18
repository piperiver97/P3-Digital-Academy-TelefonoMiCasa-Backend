package com.factoriaf5.telefono_micasa.services;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
