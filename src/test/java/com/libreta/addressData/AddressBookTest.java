package com.libreta.addressData;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
    private AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook = AddressBook.getInstancia();
        addressBook.getAddressEntryList().clear(); // Limpiar la lista antes de cada prueba
    }

    @Test
    public void testAdd() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "NY", 10001, "123-456-7890", "john@example.com");
        addressBook.add(entry);
        assertEquals(1, addressBook.getAddressEntryList().size());
        assertTrue(addressBook.getAddressEntryList().contains(entry));
    }

    @Test
    public void testFind() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "NY", 10001, "123-456-7890", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Elm St", "CA", 90210, "987-654-3210", "jane@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);

        AddressEntry foundEntry = addressBook.find("Doe");
        assertNotNull(foundEntry);
        assertEquals("John", foundEntry.getFirstName());
        assertEquals("Doe", foundEntry.getLastName());
    }

    @Test
    public void testGetAddressEntryList() {
        assertNotNull(addressBook.getAddressEntryList());
        assertTrue(addressBook.getAddressEntryList().isEmpty());
    }

    @Test
    public void testGetInstancia() {
        AddressBook instancia1 = AddressBook.getInstancia();
        AddressBook instancia2 = AddressBook.getInstancia();
        assertNotNull(instancia1);
        assertNotNull(instancia2);
        assertSame(instancia1, instancia2);
    }


    @Test
    public void testRemove() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "NY", 10001, "123-456-7890", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Elm St", "CA", 90210, "987-654-3210", "jane@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);

        addressBook.remove(null, "Doe");
        assertEquals(2, addressBook.getAddressEntryList().size());

        addressBook.remove("testfile.txt", "Doe");
        assertEquals(2, addressBook.getAddressEntryList().size());

        addressBook.remove("testfile.txt", "Doe");
        assertEquals(0, addressBook.getAddressEntryList().size());
    }

    @Test
    public void testSetAddressEntryList() {
        List<AddressEntry> lista = List.of(
                new AddressEntry("John", "Doe", "123 Main St", "NY", 10001, "123-456-7890", "john@example.com"),
                new AddressEntry("Jane", "Doe", "456 Elm St", "CA", 90210, "987-654-3210", "jane@example.com")
        );

        addressBook.setAddressEntryList(lista);
        assertEquals(2, addressBook.getAddressEntryList().size());
        assertTrue(addressBook.getAddressEntryList().containsAll(lista));
    }
}
