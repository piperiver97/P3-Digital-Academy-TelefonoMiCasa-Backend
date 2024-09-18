
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

import com.factoriaf5.telefono_micasa.models.Properti;
import com.factoriaf5.telefono_micasa.repositories.PropertiRepository;

@ExtendWith(MockitoExtension.class)
public class PropertiServiceTest {

    @Mock
    private PropertiRepository propertiRepository;

    @InjectMocks
    private PropertiService propertiService;

    @Test
    public void testGetPropertiesByAction() {
     
        Properti property1 = new Properti();
        property1.setAction("comprar");

        Properti property2 = new Properti();
        property2.setAction("comprar");
        
        List<Properti> properties = Arrays.asList(property1, property2);
        
        when(propertiRepository.findByAction("comprar")).thenReturn(properties);

      
        List<Properti> result = propertiService.getPropertiesByAction("comprar");

     
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAction()).isEqualTo("comprar");
        assertThat(result.get(1).getAction()).isEqualTo("comprar");
    }
}
