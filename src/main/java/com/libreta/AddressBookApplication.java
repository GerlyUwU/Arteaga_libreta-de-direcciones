package com.libreta;

public class AddressBookApplication {
    public static void main(String[] args) {
    //probamos la instancia de singleton (addressbook)
    AddressBook unica = AddressBook.getInstancia();
    unica.mostrarMensaje();
    }

}