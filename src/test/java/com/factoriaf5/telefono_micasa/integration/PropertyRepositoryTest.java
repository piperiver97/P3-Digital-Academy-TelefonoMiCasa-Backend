/* package com.factoriaf5.telefono_micasa.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Flat;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.repositories.PropertyRepository;
import java.util.List;

@DataJpaTest
@ActiveProfiles("h2")
public class PropertyRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired 
    PropertyRepository repository;

    @Test
    @DisplayName("Find a property for sale")
    void testFindOnePropertyForSale() {
        List<Property> propertiesForSale = repository.findByAction("venta");
        assertEquals(6, propertiesForSale.size());  
        assertThat(propertiesForSale.get(0).getDescription()).isEqualTo("Hermoso apartamento con vista al mar.");
        assertThat(propertiesForSale.get(0).getAction()).isEqualTo("venta");
    }
    
    @Test
    @DisplayName("Find a property for rent")
    void testFindOnePropertyForRent() {
        List<Property> propertiesForRent = repository.findByAction("alquiler");
        assertEquals(4, propertiesForRent.size()); 
        assertThat(propertiesForRent.get(0).getDescription()).isEqualTo("Piso céntrico en alquiler, bien comunicado.");
        assertThat(propertiesForRent.get(0).getAction()).isEqualTo("alquiler");
    }

        @Test
    @DisplayName("Find a property for rent and type . FLAT ")
    void testFindOnePropertyForRentandType() {
        List<Property> propertiesForRentAndType = repository.filterByActionAndType("alquiler", House.class);
        assertEquals(2, propertiesForRentAndType.size()); 
        
        assertThat(propertiesForRentAndType.get(0).getDescription()).isEqualTo("Casa en alquiler, ideal para familias.");
        assertThat(propertiesForRentAndType.get(0).getAction()).isEqualTo("alquiler");
        assertTrue(propertiesForRentAndType.get(0) instanceof House);
        assertThat(propertiesForRentAndType.get(1).getDescription()).isEqualTo("Casa en alquiler cerca de la playa.");
        assertThat(propertiesForRentAndType.get(1).getAction()).isEqualTo("alquiler");

        assertTrue(propertiesForRentAndType.get(1) instanceof House);
    }

    @Test
    @DisplayName("Find a property for rent and type . FLAT")
    void testFindOnePropertyForRentAndType() {
    List<Property> propertiesForRentAndType = repository.filterByActionAndType("alquiler", Flat.class);
        assertEquals(2, propertiesForRentAndType.size()); 
    
    assertThat(propertiesForRentAndType.get(0).getDescription()).isEqualTo("Piso céntrico en alquiler, bien comunicado.");
    assertThat(propertiesForRentAndType.get(0).getAction()).isEqualTo("alquiler");
    assertTrue(propertiesForRentAndType.get(0) instanceof Flat);
    assertThat(propertiesForRentAndType.get(1).getDescription()).isEqualTo("Acogedor piso en el barrio antiguo.");
    assertThat(propertiesForRentAndType.get(1).getAction()).isEqualTo("alquiler");
    assertTrue(propertiesForRentAndType.get(1) instanceof Flat);
}
    @AfterEach
    void tearDown() {
        entityManager.clear();
    }
    
}
 */