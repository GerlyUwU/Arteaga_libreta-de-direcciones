package com.libreta.address;

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
        System.out.println("Elige la opción del menú:\n");
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
        AddressBook libreta = AddressBook.getInstancia();
        switch (option) {
            case 'a':
                System.out.println("Ingresa el nombre del archivo:");
                filename = input.nextLine();
                libreta.readFromFile(filename);
                break;
            case 'b':
                entradaDatos();
                break;
            case 'c':
                System.out.println("Ingresa el apellido del contacto a eliminar:");
                String lastNameToDelete = input.nextLine();
                libreta.remove(lastNameToDelete);
                break;
            case 'd':
                System.out.println("Ingresa el apellido del contacto a buscar:");
                String lastNameToFind = input.nextLine();
                AddressEntry foundEntry = libreta.find(lastNameToFind);
                if (foundEntry != null) {
                    System.out.println(foundEntry);
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 'e':
                if (filename != null) {

                    libreta.readFromFile(filename);

                    // Itera sobre la lista de entradas y las muestra en la consola
                    for (AddressEntry entry : libreta.getAddressEntryList()) {
                        System.out.println(entry);
                    }

                } else {
                    System.out.println("El archivo no fue ingresado, intentalo nuevamente");
                }
                break;
            case 'f':
                despedida();
                break;
            default:
                System.out.println("Ese carácter no coincide con ninguna de nuestras opciones.");
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
        System.out.println("Primer nombre: ");
        String firstName = input.nextLine();
        System.out.println("Apellido: ");
        String lastName = input.nextLine();
        System.out.println("Calle: ");
        String street = input.nextLine();
        System.out.println("Estado: ");
        String state = input.nextLine();
        System.out.println("ZIP: ");
        int zip = input.nextInt();
        input.nextLine(); // Consumir el carácter de nueva línea
        System.out.println("Teléfono: ");
        String phone = input.nextLine();
        System.out.println("Email: ");
        String email = input.nextLine();

        AddressEntry nuevaEntrada = new AddressEntry(firstName, lastName, street, state, zip, phone, email);
        AddressBook libreta = AddressBook.getInstancia();
        libreta.add(nuevaEntrada);
        libreta.guardarInformacion(libreta.getAddressEntryList());
    }
}
