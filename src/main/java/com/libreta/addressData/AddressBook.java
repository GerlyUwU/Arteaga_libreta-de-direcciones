package com.libreta.addressData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private static AddressBook instancia;

    List<AddressEntry> addressEntryList;

    // el constructor es privado para evitar la instanciacion externa
    private AddressBook() {
        // aqui inicializaremos variables y recursos
        addressEntryList = new ArrayList<>();
    }

    // metodo publico estatico para obtener la instancia unica de la clase
    public static AddressBook getInstancia() {
        if (instancia == null) {
            instancia = new AddressBook();
        }
        return instancia;
    }


    public List<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }

    public void remove(String lastName) {

    }

    // que hace este metodo? supongo que solo se puede usar desde esta clase
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    public void readFromFile(String filename) {
      try (BufferedReader lector = new BufferedReader(new FileReader(filename))) {
            String linea;
            int numeroContacto = 1; // Variable para enumerar los contactos
            boolean primerNombre = true; // Flag para indicar si estamos en el primer nombre de un contacto
            while ((linea = lector.readLine()) != null) {
                if (primerNombre && !linea.isEmpty()) {
                    System.out.println(numeroContacto + ". " + linea);
                    primerNombre = false; // Cambiar el flag después de mostrar el primer nombre
                } else {
                    System.out.println(linea);
                }
                if (linea.isEmpty()) {
                    primerNombre = true; // Restaurar el flag al encontrar una línea en blanco
                    numeroContacto++; // Incrementar el número de contacto al encontrar una línea en blanco
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void find() {

    }

    public void guardarInformacion(List<AddressEntry> addressEntryList) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("directorio.txt", true))) {
            for (AddressEntry addressEntry : addressEntryList) {
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
                escritor.newLine();  //añadimos una linea en blanco entre entradas
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
