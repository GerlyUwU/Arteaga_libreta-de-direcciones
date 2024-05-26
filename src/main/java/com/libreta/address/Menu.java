package com.libreta.address;

import java.util.Scanner;

import com.libreta.addressData.AddressBook;

public class Menu {
    static String filename;
    static Scanner input = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("===================================================\n");
        System.out.println("Elige la opción del menu:\n");
        System.out.println("a) Cargar de archivo");
        System.out.println("b) Agregar");
        System.out.println("c) Eliminar");
        System.out.println("d) Buscar");
        System.out.println("e) Mostrar");
        System.out.println("f) Salir \n");
        System.out.println("===================================================\n");
    }

    public static void menuInAction(char option) {
        switch (option) {
            case 'a':
                System.out.println("Ingresa el nombre del archivo");
                filename = input.nextLine();
                Menu.displayMenu();
                break;

            case 'e':
                AddressBook libreta = AddressBook.getInstancia();
                if (filename == null) {
                    System.out.println("primero ingrese el nombre del documento");
                    return;
                } else {
                    libreta.readFromFile(filename);
                }
                break;
                case 'f':
                despedida();
                break;  
            default:
                System.out.println("Ese caracter no coincide con ninguna de nuestras opciones");
                break;
        }
    }

    public static void despedida() {
        System.out.println("\n");
        System.out.println("Gracias por usar la libreta de direcciones :)\n");
    }
}
