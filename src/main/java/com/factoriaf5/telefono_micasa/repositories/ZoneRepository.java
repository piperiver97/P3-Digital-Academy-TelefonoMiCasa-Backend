package com.factoriaf5.telefono_micasa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.factoriaf5.telefono_micasa.models.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    
}
