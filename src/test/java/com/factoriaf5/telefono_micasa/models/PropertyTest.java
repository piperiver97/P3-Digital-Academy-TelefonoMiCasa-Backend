package com.factoriaf5.telefono_micasa.models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyTest {

    @Test
    public void testPropertiConstructor() {
        Property properti = new Property(1L, 150000.0, "Casa 1", "Calle A", 120.0, "venta");

        assertEquals(1L, properti.getId());
        assertEquals(150000.0, properti.getPrice());
        assertEquals("Casa 1", properti.getDescription());
        assertEquals("Calle A", properti.getAddress());
        assertEquals(120.0, properti.getArea());
        assertEquals("venta", properti.getAction());
    }

    @Test
    public void testSettersAndGetters() {
        Property properti = new Property();

        properti.setId(2L);
        properti.setPrice(200000.0);
        properti.setDescription("Casa 2");
        properti.setAddress("Calle B");
        properti.setArea(150.0);
        properti.setAction("compra");

        assertEquals(2L, properti.getId());
        assertEquals(200000.0, properti.getPrice());
        assertEquals("Casa 2", properti.getDescription());
        assertEquals("Calle B", properti.getAddress());
        assertEquals(150.0, properti.getArea());
        assertEquals("compra", properti.getAction());
    }


}
