package com.libreta.addressData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class representing an address book.
 */
public class AddressBook {
    private static AddressBook instancia;
    private List<AddressEntry> addressEntryList;

    /**
     * Private constructor to avoid external instantiation.
     */
    private AddressBook() {
        addressEntryList = new ArrayList<>();
    }

    /**
     * Returns the unique instance of the AddressBook class.
     *
     * @return the singleton instance of AddressBook
     */
    public static AddressBook getInstancia() {
        if (instancia == null) {
            instancia = new AddressBook();
        }
        return instancia;
    }

    /**
     * Gets the list of address entries.
     *
     * @return the list of AddressEntry objects
     */
    public List<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }

    /**
     * Removes an address entry based on the last name.
     *
     * @param lastName the last name of the entry to be removed
     */
    public void remove(String lastName) {
        addressEntryList.removeIf(entry -> entry.getLastName().equalsIgnoreCase(lastName));
    }

    /**
     * Adds a new address entry to the address book.
     *
     * @param addressEntry the AddressEntry object to be added
     */
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    /**
     * Reads address entries from a file and populates the address book.
     *
     * @param filename the name of the file to read from
     */
    public void readFromFile(String filename) {
        try (BufferedReader lector = new BufferedReader(new FileReader(filename))) {
            String linea;
            AddressEntry addressEntry = new AddressEntry();
            while ((linea = lector.readLine()) != null) {
                if (linea.startsWith("First Name: ")) {
                    addressEntry.setFirstName(linea.substring(12));
                } else if (linea.startsWith("Last Name: ")) {
                    addressEntry.setLastName(linea.substring(11));
                } else if (linea.startsWith("Street: ")) {
                    addressEntry.setStreet(linea.substring(8));
                } else if (linea.startsWith("State: ")) {
                    addressEntry.setState(linea.substring(7));
                } else if (linea.startsWith("ZIP: ")) {
                    addressEntry.setZip(Integer.parseInt(linea.substring(5)));
                } else if (linea.startsWith("Phone: ")) {
                    addressEntry.setPhone(linea.substring(7));
                } else if (linea.startsWith("Email: ")) {
                    addressEntry.setEmail(linea.substring(7));
                } else if (linea.isEmpty()) {
                    addressEntryList.add(addressEntry);
                    addressEntry = new AddressEntry();
                }
            }
            // Add the last entry if the file does not end with a blank line
            if (addressEntry.getFirstName() != null) {
                addressEntryList.add(addressEntry);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Finds an address entry based on the last name.
     *
     * @param lastName the last name to search for
     * @return the first AddressEntry that matches the last name, or null if none
     *         found
     */
    public AddressEntry find(String lastName) {
        return addressEntryList.stream()
                .filter(entry -> entry.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Saves the address entries to a file.
     *
     * @param addressEntryList the list of AddressEntry objects to be saved
     */
    public void guardarInformacion(List<AddressEntry> addressEntryList) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("directorio.txt", true))) {
            for (AddressEntry addressEntry : addressEntryList) {
                escribirEntrada(escritor, addressEntry);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Writes a single address entry to the provided BufferedWriter.
     *
     * @param escritor     the BufferedWriter to write to
     * @param addressEntry the AddressEntry object to be written
     * @throws IOException if an I/O error occurs
     */
    private void escribirEntrada(BufferedWriter escritor, AddressEntry addressEntry) throws IOException {
        escritor.write("First Name: " + addressEntry.getFirstName());
        escritor.newLine();
        escritor.write("Last Name: " + addressEntry.getLastName());
        escritor.newLine();
        escritor.write("Street: " + addressEntry.getStreet());
        escritor.newLine();
        escritor.write("State: " + addressEntry.getState());
        escritor.newLine();
        escritor.write("ZIP: " + addressEntry.getZip());
        escritor.newLine();
        escritor.write("Phone: " + addressEntry.getPhone());
        escritor.newLine();
        escritor.write("Email: " + addressEntry.getEmail());
        escritor.newLine();
        escritor.newLine(); // Add a blank line between entries
    }
}
