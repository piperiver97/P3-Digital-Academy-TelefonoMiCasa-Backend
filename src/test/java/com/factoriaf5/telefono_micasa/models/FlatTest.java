package com.factoriaf5.telefono_micasa.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlatTest {

    @Test
    public void testFlatConstructor() {
        Flat flat = new Flat(1L, 150000.0, "Piso céntrico en alquiler, bien comunicado.", 
                              "Plaza Mayor 789, Avilés", 60.0, "alquiler", 
                              1, 1, false);

        assertEquals(1L, flat.getId());
        assertEquals(150000.0, flat.getPrice());
        assertEquals("Piso céntrico en alquiler, bien comunicado.", flat.getDescription());
        assertEquals("Plaza Mayor 789, Avilés", flat.getAddress());
        assertEquals(60.0, flat.getArea());
        assertEquals("alquiler", flat.getAction());
        assertEquals(1, flat.getRoom());
        assertEquals(1, flat.getBathroom());
        assertFalse(flat.isHasElevator());
    }

    @Test
    public void testSettersAndGetters() {
        Flat flat = new Flat();

        flat.setId(2L);
        flat.setPrice(200000.0);
        flat.setDescription("Acogedor piso en el barrio antiguo.");
        flat.setAddress("Calle de la Historia 34, Gijón");
        flat.setArea(50.0);
        flat.setAction("alquiler");
        flat.setRoom(2);
        flat.setBathroom(1);
        flat.setHasElevator(true);

        assertEquals(2L, flat.getId());
        assertEquals(200000.0, flat.getPrice());
        assertEquals("Acogedor piso en el barrio antiguo.", flat.getDescription());
        assertEquals("Calle de la Historia 34, Gijón", flat.getAddress());
        assertEquals(50.0, flat.getArea());
        assertEquals("alquiler", flat.getAction());
        assertEquals(2, flat.getRoom());
        assertEquals(1, flat.getBathroom());
        assertTrue(flat.isHasElevator());
    }
}
