/* package com.factoriaf5.telefono_micasa.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import com.factoriaf5.telefono_micasa.models.House;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.services.PropertyService;


@WebMvcTest(PropertyController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyService propertyService;

    @Test
    public void testGetPropertiesByAction() throws Exception {
        List<Property> mockProperties = Arrays.asList(
            new Property(1L, 150000.0, "Casa 1", "Calle A", 120.0, "compra"),
            new Property(2L, 200000.0, "Casa 2", "Calle B", 150.0, "compra")
        );

        when(propertyService.getPropertiesByAction("venta")).thenReturn(mockProperties);

        mockMvc.perform(get("/api/v1/search/action_type")
                .param("action", "venta"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].price").value(150000.0))
                .andExpect(jsonPath("$[0].description").value("Casa 1"));
    }

    @Test
    public void testFilterProperties() throws Exception {
        List<Property> mockProperties = Arrays.asList(
            new House(3L, 200000.0, "Casa bonita", "Calle B", 150.0, "alquiler", 3, 2)
        );

        when(propertyService.filterProperties("HOUSE", "alquiler")).thenReturn(mockProperties);

        
        mockMvc.perform(get("/api/v1/search/filter")
                .param("type", "HOUSE")
                .param("action", "alquiler"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].price").value(200000.0))
                .andExpect(jsonPath("$[0].description").value("Casa bonita"))
                .andExpect(jsonPath("$[0].address").value("Calle B"))
                .andExpect(jsonPath("$[0].area").value(150.0))
                .andExpect(jsonPath("$[0].action").value("alquiler"))
                .andExpect(jsonPath("$[0].room").value(3))
                .andExpect(jsonPath("$[0].bathroom").value(2));
    }
}

 */