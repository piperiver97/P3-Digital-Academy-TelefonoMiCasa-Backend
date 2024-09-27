package com.factoriaf5.telefono_micasa.repositories;

import java.util.List;
import java.util.Optional;

import com.factoriaf5.telefono_micasa.models.Role;
import com.factoriaf5.telefono_micasa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findByRolesIn(List<Role> role);
}
