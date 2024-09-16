package com.factoriaf5.telefono_micasa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.factoriaf5.telefono_micasa.models.Properti;



public interface PropertiRepository extends JpaRepository <Properti, Long>{

    @Query("SELECT p FROM Properti p WHERE p.action = :action")
    List<Properti> findByAction (@Param("action") String action);
}
