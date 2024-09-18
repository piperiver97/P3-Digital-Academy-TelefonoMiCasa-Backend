package com.factoriaf5.telefono_micasa.repositories;

import com.factoriaf5.telefono_micasa.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
