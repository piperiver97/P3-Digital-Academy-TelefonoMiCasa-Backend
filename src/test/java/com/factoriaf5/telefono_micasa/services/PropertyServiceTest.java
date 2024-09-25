/* package com.factoriaf5.telefono_micasa.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.factoriaf5.telefono_micasa.models.Flat;
import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.repositories.PropertyRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyService propertyService;

    @Test
    public void testGetPropertiesByAction() {
        
        Property property1 = new House(1L, 250000.0, "Casa espaciosa", "Calle del Jardín", 150.0, "venta", 4, 2);
        Property property2 = new Flat(2L, 180000.0, "Piso moderno", "Avenida Libertad", 75.0, "venta", 2, 1, true);
        
        List<Property> properties = Arrays.asList(property1, property2);

        when(propertyRepository.findByAction("venta")).thenReturn(properties);

        List<Property> result = propertyService.getPropertiesByAction("venta");

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAction()).isEqualTo("venta");
        assertThat(result.get(1).getAction()).isEqualTo("venta");
    }

    @Test
    public void testFilterPropertiesForHouse() {
        Property property1 = new House(3L, 1500.0, "Casa en alquiler", "Avenida de la Familia", 110.0, "alquiler", 3, 2);
        Property property2 = new House(4L, 1200.0, "Casa cerca de la playa", "Calle del Sol", 90.0, "alquiler", 2, 1);

        List<Property> properties = Arrays.asList(property1, property2);

        when(propertyRepository.filterByActionAndType("alquiler", House.class)).thenReturn(properties);

        List<Property> result = propertyService.filterProperties("HOUSE", "alquiler");

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAction()).isEqualTo("alquiler");
        assertThat(result.get(1).getAction()).isEqualTo("alquiler");
        assertThat(result.get(0)).isInstanceOf(House.class);
        assertThat(result.get(1)).isInstanceOf(House.class);
    }

    @Test
    public void testFilterPropertiesForFlat() {
        Property property1 = new Flat(5L, 1200.0, "Piso céntrico", "Plaza Mayor", 60.0, "alquiler", 1, 1, false);
        Property property2 = new Flat(6L, 900.0, "Piso acogedor", "Calle Historia", 50.0, "alquiler", 1, 1, false);

        List<Property> properties = Arrays.asList(property1, property2);

        when(propertyRepository.filterByActionAndType("alquiler", Flat.class)).thenReturn(properties);

        List<Property> result = propertyService.filterProperties("FLAT", "alquiler");

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getAction()).isEqualTo("alquiler");
        assertThat(result.get(1).getAction()).isEqualTo("alquiler");
        assertThat(result.get(0)).isInstanceOf(Flat.class);
        assertThat(result.get(1)).isInstanceOf(Flat.class);
    }

    @Test
    public void testInvalidPropertyType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            propertyService.filterProperties("INVALID_TYPE", "venta");
        });

        assertThat(exception.getMessage()).isEqualTo("Tipo de propiedad no válido");
    }
}
 */