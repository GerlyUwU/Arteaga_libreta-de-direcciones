package com.libreta.address;

import com.libreta.addressData.AddressBook;

public class AddressBookApplication {
    public static void main(String[] args) {
        // probamos la instancia de singleton (addressbook)
        AddressBook unica = AddressBook.getInstancia();
        unica.mostrarMensaje();
        fizzBuzz();
    }

    public static void fizzBuzz() {
        for (int i = 0; i <= 100; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}