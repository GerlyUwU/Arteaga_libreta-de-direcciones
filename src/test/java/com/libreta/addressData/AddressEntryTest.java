package com.libreta.addressData;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddressEntryTest {
    @Test
    public void testGetEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("test@example.com");
        assertEquals("test@example.com", entry.getEmail());
    }

    @Test
    public void testGetFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("John");
        assertEquals("John", entry.getFirstName());
    }

    @Test
    public void testGetLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("Doe");
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    public void testGetPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("123-456-7890");
        assertEquals("123-456-7890", entry.getPhone());
    }

    @Test
    public void testGetState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("NY");
        assertEquals("NY", entry.getState());
    }

    @Test
    public void testGetStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("123 Main St");
        assertEquals("123 Main St", entry.getStreet());
    }

    @Test
    public void testGetZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(10001);
        assertEquals(10001, entry.getZip());
    }

    @Test
    public void testSetEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("test@example.com");
        assertEquals("test@example.com", entry.getEmail());
    }

    @Test
    public void testSetFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("John");
        assertEquals("John", entry.getFirstName());
    }

    @Test
    public void testSetLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("Doe");
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    public void testSetPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("123-456-7890");
        assertEquals("123-456-7890", entry.getPhone());
    }

    @Test
    public void testSetState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("NY");
        assertEquals("NY", entry.getState());
    }

    @Test
    public void testSetStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("123 Main St");
        assertEquals("123 Main St", entry.getStreet());
    }

    @Test
    public void testSetZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(10001);
        assertEquals(10001, entry.getZip());
    }

    @Test
    public void testToString() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "NY", 10001, "123-456-7890", "john@example.com");
        String expected = "Nombre ='John', Apellido='Doe', Dirección ='123 Main St', Estado ='NY', Código ZIP =10001, Teléfono ='123-456-7890', Correo electrónico ='john@example.com'";
        assertEquals(expected, entry.toString());
    }
}
