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
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("directorio.txt", true));
            for (AddressEntry addressEntry : addressEntryList) {
                escritor.write(addressEntry.getFirstName() + "\t" +
                        addressEntry.getLastName() + "\t" + addressEntry.getStreet()
                        + "\t" + addressEntry.getState() + "\t" + String.valueOf(addressEntry.getZip())
                        + "\t" + addressEntry.getPhone() + "\t" + addressEntry.getEmail());
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("error al escribir en el archivo " + e.getMessage());
        }
    }

}
