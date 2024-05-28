package com.libreta.addressData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que representa una libreta de direcciones.
 */
public class AddressBook {
    private static AddressBook instancia;
    private List<AddressEntry> addressEntryList;

    /**
     * Constructor privado para evitar la instanciación externa.
     */
    private AddressBook() {
        addressEntryList = new ArrayList<>();
    }

    /**
     * Devuelve la instancia única de la clase AddressBook.
     *
     * @return la instancia singleton de AddressBook
     */
    public static AddressBook getInstancia() {
        if (instancia == null) {
            instancia = new AddressBook();
        }
        return instancia;
    }

    /**
     * Obtiene la lista de entradas de direcciones.
     *
     * @return la lista de objetos AddressEntry
     */
    public List<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }

    /**
     * Elimina una entrada de dirección basada en el apellido.
     *
     * @param lastName el apellido de la entrada a eliminar
     */
    public void remove(String lastName) {
        addressEntryList.removeIf(entry -> entry.getLastName().equalsIgnoreCase(lastName));
        guardarInformacion(addressEntryList);
    }

    /**
     * Agrega una nueva entrada de dirección a la libreta de direcciones.
     *
     * @param addressEntry el objeto AddressEntry a agregar
     */
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
        guardarInformacion(addressEntryList);
    }

    /**
     * Lee las entradas de direcciones de un archivo y las carga en la libreta.
     *
     * @param filename el nombre del archivo del cual leer
     */
    public void readFromFile(String filename) {
        addressEntryList.clear(); // Limpiar las entradas existentes antes de leer del archivo
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
            // Agregar la última entrada si el archivo no termina con una línea en blanco
            if (addressEntry.getFirstName() != null) {
                addressEntryList.add(addressEntry);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Encuentra una entrada de dirección basada en el apellido.
     *
     * @param lastName el apellido a buscar
     * @return la primera AddressEntry que coincide con el apellido, o null si no se encuentra
     */
    public AddressEntry find(String lastName) {
        return addressEntryList.stream()
                .filter(entry -> entry.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Guarda las entradas de direcciones en un archivo.
     *
     * @param addressEntryList la lista de objetos AddressEntry a guardar
     */
    public void guardarInformacion(List<AddressEntry> addressEntryList) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("directorio.txt"))) {
            for (AddressEntry addressEntry : addressEntryList) {
                escribirEntrada(escritor, addressEntry);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Escribe una sola entrada de dirección en el BufferedWriter proporcionado.
     *
     * @param escritor el BufferedWriter en el cual escribir
     * @param addressEntry el objeto AddressEntry a escribir
     * @throws IOException si ocurre un error de I/O
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
        escritor.newLine(); // Añadir una línea en blanco entre entradas
    }
}
