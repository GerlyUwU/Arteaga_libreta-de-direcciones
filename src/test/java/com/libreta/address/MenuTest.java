package com.libreta.address;

import com.libreta.addressData.AddressBook;
import com.libreta.addressData.AddressEntry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("".getBytes());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
        System.setIn(System.in);
    }

    @Test
    public void testDespedida() {
        Menu.despedida();
        assertEquals("\nGracias por usar la libreta de direcciones :)\n\n", outContent.toString());
    }

    @Test
    public void testDisplayMenu() {
        Menu.displayMenu();
        String expectedOutput = "===================================================\n" +
                                "\n" +
                                "Elige la opción del menú:\n" +
                                "\n" +
                                "a) Cargar de archivo\n" +
                                "b) Agregar\n" +
                                "c) Eliminar\n" +
                                "d) Buscar\n" +
                                "e) Mostrar\n" +
                                "f) Salir \n" +
                                "\n" +
                                "===================================================\n" +
                                "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testEntradaDatos() {
        String data = "John\n" +
                      "Doe\n" +
                      "123 Main St\n" +
                      "CA\n" +
                      "12345\n" +
                      "555-555-5555\n" +
                      "john.doe@example.com\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu.entradaDatos();
        AddressBook addressBook = AddressBook.getInstancia();
        List<AddressEntry> addressEntries = addressBook.getAddressEntryList();
        assertEquals(1, addressEntries.size());
        AddressEntry addressEntry = addressEntries.get(0);
        assertEquals("John", addressEntry.getFirstName());
        assertEquals("Doe", addressEntry.getLastName());
        assertEquals("123 Main St", addressEntry.getStreet());
        assertEquals("CA", addressEntry.getState());
        assertEquals(12345, addressEntry.getZip());
        assertEquals("555-555-5555", addressEntry.getPhone());
        assertEquals("john.doe@example.com", addressEntry.getEmail());
    }

    @Test
    public void testMenuInAction() {
        // Mock input for testing
        ByteArrayInputStream in = new ByteArrayInputStream("b\nJohn\nDoe\n123 Main St\nCA\n12345\n555-555-5555\njohn.doe@example.com\nf\n".getBytes());
        System.setIn(in);

        // Mock AddressBook
        AddressBook addressBook = AddressBook.getInstancia();
        List<AddressEntry> addressEntries = new ArrayList<>();
        addressBook.setAddressEntryList(addressEntries);

        // Execute menu actions
        Menu.menuInAction('b'); // Add new entry
        Menu.menuInAction('f'); // Exit

        // Assert that entry was added
        assertEquals(1, addressEntries.size());
        AddressEntry addedEntry = addressEntries.get(0);
        assertEquals("John", addedEntry.getFirstName());
        assertEquals("Doe", addedEntry.getLastName());
        assertEquals("123 Main St", addedEntry.getStreet());
        assertEquals("CA", addedEntry.getState());
        assertEquals(12345, addedEntry.getZip());
        assertEquals("555-555-5555", addedEntry.getPhone());
        assertEquals("john.doe@example.com", addedEntry.getEmail());

        // Assert that despedida() was called
        assertEquals("\nGracias por usar la libreta de direcciones :)\n\n", outContent.toString());
    }
}
