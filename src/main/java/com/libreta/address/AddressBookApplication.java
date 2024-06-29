package com.libreta.address;

import java.util.Scanner;

/**
 * La clase AddressBookApplication representa la aplicación principal para interactuar
 * con la libreta de direcciones.
 */
public class AddressBookApplication {

    /**
     * Método principal que inicia la aplicación de la libreta de direcciones.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char option;

        // Muestra el menú y procesa la entrada del usuario hasta que se selecciona 'f' (finalizar)
        do { 
            Menu.displayMenu();
            option = teclado.next().charAt(0);
            Menu.menuInAction(option);
        } while (option != 'f');
    }

   
}
//hola a toda mi gente del yutu