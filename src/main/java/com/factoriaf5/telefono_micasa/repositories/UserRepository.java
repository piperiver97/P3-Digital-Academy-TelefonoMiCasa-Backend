package com.factoriaf5.telefono_micasa.repositories;

import java.util.Optional;

import com.factoriaf5.telefono_micasa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

}
