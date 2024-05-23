package com.libreta.addressData;

//vamos a aplicar el patron  singleton en esta clase

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

    // ejemplo de metodo que podria tener la clase con la
    // restriccion de singleton:
    public void mostrarMensaje() {
        System.out.println("hola desde singleton!");

    }

    public List<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }

    public void remove(String lastName) {

    }

    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    public void readFromFile(String filename) {

    }

    public void find() {

    }

}
