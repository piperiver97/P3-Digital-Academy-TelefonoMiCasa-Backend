package com.factoriaf5.telefono_micasa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.factoriaf5.telefono_micasa.models.Zone;


public interface ZoneRepository extends JpaRepository<Zone, Long> {
    
}
