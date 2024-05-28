package com.libreta.address;

import java.util.List;
import java.util.Scanner;

import com.libreta.addressData.AddressBook;
import com.libreta.addressData.AddressEntry;

/**
 * La clase Menu proporciona un menú interactivo para interactuar con la libreta
 * de direcciones.
 */
public class Menu {
    static String filename;
    static Scanner input = new Scanner(System.in);

    /**
     * Muestra el menú de opciones disponibles.
     */
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

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada.
     * 
     * @param option La opción seleccionada del menú.
     */
    public static void menuInAction(char option) {
        switch (option) {
            case 'a':
                System.out.println("Ingresa el nombre del archivo");
                filename = input.nextLine();
                break;
            case 'b':
                entradaDatos();
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

    /**
     * Muestra un mensaje de despedida al usuario.
     */
    public static void despedida() {
        System.out.println("\n");
        System.out.println("Gracias por usar la libreta de direcciones :)\n");
    }

    /**
     * Solicita al usuario que ingrese los datos para una nueva entrada en la
     * libreta de direcciones.
     */
    public static void entradaDatos() {
        String firstName;
        String lastName;
        String street;
        String state;
        int zip;
        String phone;
        String email;

        System.out.println("\n");
        System.out.println("Primer nombre: ");
        firstName = input.nextLine();
        System.out.println("\n");
        System.out.println("Apellido: ");
        lastName = input.nextLine();
        System.out.println("\n");
        System.out.println("Calle: ");
        street = input.nextLine();
        System.out.println("\n");
        System.out.println("Estado: ");
        state = input.nextLine();
        System.out.println("\n");
        System.out.println("ZIP: ");
        zip = input.nextInt();
        System.out.println("\n");
        System.out.println("Telefono: ");
        phone = input.nextLine();
        System.out.println("\n");
        System.out.println("Email: ");
        email = input.nextLine();
        System.out.println("\n");

        AddressEntry nuevaEntrada = new AddressEntry(firstName, lastName, street,
                state, zip, phone, email);
        AddressBook libreta = AddressBook.getInstancia();
        libreta.add(nuevaEntrada);
        List<AddressEntry> direcciones = libreta.getAddressEntryList();
        libreta.guardarInformacion(direcciones);
    }
}
