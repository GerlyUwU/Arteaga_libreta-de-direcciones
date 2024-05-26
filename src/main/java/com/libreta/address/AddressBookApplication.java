package com.libreta.address;

import java.util.Scanner;

public class AddressBookApplication {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char option;

        do { 
            Menu.displayMenu();
            option = teclado.next().charAt(0);
            Menu.menuInAction(option);
        } while (option != 'f');
        
       
    }

}