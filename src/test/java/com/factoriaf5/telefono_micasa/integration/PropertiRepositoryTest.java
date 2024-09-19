package com.factoriaf5.telefono_micasa.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import com.factoriaf5.telefono_micasa.models.Properti;
import com.factoriaf5.telefono_micasa.repositories.PropertiRepository;
import java.util.List;

@DataJpaTest
@ActiveProfiles("h2")
public class PropertiRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired 
    PropertiRepository repository;

    @Test
    @DisplayName("Find a property for sale")
    void testFindOnePropertyForSale() {
        List<Properti> propertiesForSale = repository.findByAction("venta");
        assertEquals(3, propertiesForSale.size());  
        assertThat(propertiesForSale.get(0).getDescription()).isEqualTo("Hermoso apartamento con vista al mar.");
        assertThat(propertiesForSale.get(0).getAction()).isEqualTo("venta");
    }
    
    @Test
    @DisplayName("Find a property for rent")
    void testFindOnePropertyForRent() {
        List<Properti> propertiesForRent = repository.findByAction("alquiler");
        assertEquals(1, propertiesForRent.size()); 
        assertThat(propertiesForRent.get(0).getDescription()).isEqualTo("Piso céntrico en alquiler, bien comunicado.");
        assertThat(propertiesForRent.get(0).getAction()).isEqualTo("alquiler");
    }
    
    @AfterEach
    void tearDown() {
        entityManager.clear();
    }
    
}
