package com.factoriaf5.telefono_micasa.controller;

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

import com.factoriaf5.telefono_micasa.models.Properti;
import com.factoriaf5.telefono_micasa.services.PropertiService;


@WebMvcTest(PropertiController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PropertiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertiService propertiService;

    @Test
    public void testGetPropertiesByAction() throws Exception {
        List<Properti> mockProperties = Arrays.asList(
            new Properti(1L, 150000.0, "Casa 1", "Calle A", 120.0, "compra"),
            new Properti(2L, 200000.0, "Casa 2", "Calle B", 150.0, "compra")
        );

        when(propertiService.getPropertiesByAction("venta")).thenReturn(mockProperties);

        mockMvc.perform(get("/api/v1/search/action_type")
                .param("action", "venta"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].price").value(150000.0))
                .andExpect(jsonPath("$[0].description").value("Casa 1"));
    }
}

