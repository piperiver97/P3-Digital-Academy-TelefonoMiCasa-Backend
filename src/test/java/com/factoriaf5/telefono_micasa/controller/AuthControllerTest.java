package com.factoriaf5.telefono_micasa.controller;

import static org.hamcrest.MatcherAssert.assertThat;  // Ensure Hamcrest's assertThat is used
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "bob", roles = { "SALESMAN" })
    void testLoginAsSalesman() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/login") //mockMvc.perform, simula la peticion
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted()) //debe dar un 200
                .andReturn()
                .getResponse();

        String content = response.getContentAsString();
        assertNotNull(content);

        System.out.println(content);
       
        assertThat(content, containsString("roles"));
        assertThat(content, containsString("Logged"));
        assertThat(content, containsString("bob"));
        assertThat(content, is("{\"roles\":\"ROLE_SALESMAN\",\"message\":\"Logged\",\"username\":\"bob\"}"));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void testLoginAsAdmin() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse();

        String content = response.getContentAsString();
        assertNotNull(content);
        
        System.out.println(content);
       
        assertThat(content, containsString("roles"));
        assertThat(content, containsString("Logged"));
        assertThat(content, containsString("admin"));
        assertThat(content, is("{\"roles\":\"ROLE_ADMIN\",\"message\":\"Logged\",\"username\":\"admin\"}"));
    }
}
