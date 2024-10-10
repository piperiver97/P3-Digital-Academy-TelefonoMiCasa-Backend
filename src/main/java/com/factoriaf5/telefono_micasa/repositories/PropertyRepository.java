package com.factoriaf5.telefono_micasa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.factoriaf5.telefono_micasa.models.Property;



public interface PropertyRepository extends JpaRepository <Property, Long>{

    @Query("SELECT p FROM Property p WHERE p.action = :action")
    List<Property> findByAction (@Param("action") String action);

    @Query("SELECT p FROM Property p WHERE p.action = :action AND TYPE(p) = :propertyType AND LOWER(p.address) LIKE LOWER(CONCAT('%', :address, '%'))")
    List<Property> filterByActionTypeAndAddress(@Param("action") String action, @Param("propertyType") Class<?> propertyType, @Param("address") String address);
    }
    
