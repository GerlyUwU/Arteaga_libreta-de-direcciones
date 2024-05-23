package com.libreta.address;

import java.util.List;

import com.libreta.addressData.AddressBook;
import com.libreta.addressData.AddressEntry;

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook libreta = AddressBook.getInstancia();
        libreta.add(new AddressEntry("GERLY DANIEL",
                "ARTEAGA BERNAL", "CALLE NAYARIT", "VERACRUZ", 96980,
                "9231283191", "ARTEAGA.BERNAL3@GMAIL.COM"));

   List<AddressEntry> direcciones =libreta.getAddressEntryList();
   libreta.guardarInformacion(direcciones);
    }

}