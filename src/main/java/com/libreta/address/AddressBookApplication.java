package com.libreta.address;

import java.util.List;

import com.libreta.addressData.AddressBook;
import com.libreta.addressData.AddressEntry;

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook libreta = AddressBook.getInstancia();
        libreta.add(new AddressEntry("HECTOR LUIS",
                "ARTEAGA BERNAL", "CALLE EL DESENGAÑO", "VERACRUZ", 96980,
                "9612371191", "ARTEAGA.HECTOR@GMAIL.COM"));
                

        Menu.displayMenu();


   List<AddressEntry> direcciones =libreta.getAddressEntryList();
   libreta.guardarInformacion(direcciones);
    }

}