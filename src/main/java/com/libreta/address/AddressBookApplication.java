package com.libreta.address;

import com.libreta.addressData.AddressEntry;

public class AddressBookApplication {
    public static void main(String[] args) {
        // probamos la instancia de singleton (addressbook)
        AddressEntry gerly = new AddressEntry("gerly", "arteaga", "nayarit",
         "Nayarit", 96980, "9231283191", "arteaga.bernal3@gmail.com");
        System.out.println(gerly.toString());
    }

   
    
}