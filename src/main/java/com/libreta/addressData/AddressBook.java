package com.libreta.addressData;

import java.io.BufferedWriter;
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
