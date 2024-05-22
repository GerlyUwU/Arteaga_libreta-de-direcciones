package com.libreta.addressData;
//vamos a aplicar el patron  singleton en esta clase
public class AddressBook {
    private static AddressBook instancia; 


    // el constructor es privado para evitar la instanciacion externa
    private AddressBook(){
        //aqui inicializaremos variables y recursos
    }
    //metodo publico estatico para obtener la instancia unica de la clase
    public static AddressBook getInstancia(){
        if(instancia == null){
            instancia = new AddressBook();
        }
        return instancia;
    }

    //ejemplo de metodo que podria tener la clase con la  
    //restriccion de singleton: 
    public void mostrarMensaje(){
        System.out.println("hola desde singleton!");

    }


}
