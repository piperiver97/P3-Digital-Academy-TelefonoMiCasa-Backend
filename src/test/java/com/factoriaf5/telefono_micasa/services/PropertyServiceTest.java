
package com.factoriaf5.telefono_micasa.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.repositories.PropertyRepository;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyService propertyService;

    @Test
    public void testGetPropertiesByAction() {
     
        Property property1 = new Property();
        property1.setAction("comprar");

        Property property2 = new Property();
        property2.setAction("comprar");
        
        List<Property> properties = Arrays.asList(property1, property2);
        
        when(propertyRepository.findByAction("comprar")).thenReturn(properties);

      
        List<Property> result = propertyService.getPropertiesByAction("comprar");

     
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAction()).isEqualTo("comprar");
        assertThat(result.get(1).getAction()).isEqualTo("comprar");
    }
}
