package com.factoriaf5.telefono_micasa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.factoriaf5.telefono_micasa.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    static User findByUsername(String username) {
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }
}
