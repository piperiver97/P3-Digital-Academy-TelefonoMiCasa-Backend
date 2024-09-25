/* package com.factoriaf5.telefono_micasa.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {

    @Test
    public void testHouseConstructor() {
        House house = new House(1L, 250000.0, "Casa espaciosa con jardín y piscina.", 
                                "Calle del Jardín 10, Gijón", 150.0, "venta", 
                                4, 2);

        assertEquals(1L, house.getId());
        assertEquals(250000.0, house.getPrice());
        assertEquals("Casa espaciosa con jardín y piscina.", house.getDescription());
        assertEquals("Calle del Jardín 10, Gijón", house.getAddress());
        assertEquals(150.0, house.getArea());
        assertEquals("venta", house.getAction());
        assertEquals(4, house.getRoom());
        assertEquals(2, house.getBathroom());
    }

    @Test
    public void testSettersAndGetters() {
        House house = new House();

        house.setId(2L);
        house.setPrice(180000.0);
        house.setDescription("Acogedora casa en una zona tranquila.");
        house.setAddress("Calle de la Paz 45, Avilés");
        house.setArea(120.0);
        house.setAction("venta");
        house.setRoom(3);
        house.setBathroom(1);

        assertEquals(2L, house.getId());
        assertEquals(180000.0, house.getPrice());
        assertEquals("Acogedora casa en una zona tranquila.", house.getDescription());
        assertEquals("Calle de la Paz 45, Avilés", house.getAddress());
        assertEquals(120.0, house.getArea());
        assertEquals("venta", house.getAction());
        assertEquals(3, house.getRoom());
        assertEquals(1, house.getBathroom());
    }
}
 */