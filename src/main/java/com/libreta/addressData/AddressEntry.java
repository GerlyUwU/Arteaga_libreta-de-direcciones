package com.libreta.addressData;

/**
 * Clase que representa una entrada de dirección en la libreta de direcciones.
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String state;
    private int zip;
    private String phone;
    private String email;

    /**
     * Constructor por defecto.
     */
    public AddressEntry() {
    }

    /**
     * Constructor parametrizado para inicializar todos los campos.
     *
     * @param firstName el nombre del contacto
     * @param lastName  el apellido del contacto
     * @param street    la dirección del contacto
     * @param state     el estado del contacto
     * @param zip       el código ZIP del contacto
     * @param phone     el número de teléfono del contacto
     * @param email     el correo electrónico del contacto
     */
    public AddressEntry(String firstName, String lastName, String street, String state, int zip, String phone,
            String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Devuelve el nombre.
     *
     * @return el nombre
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el nombre.
     *
     * @param firstName el nuevo nombre
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Devuelve el apellido.
     *
     * @return el apellido
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido.
     *
     * @param lastName el nuevo apellido
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Devuelve la dirección.
     *
     * @return la dirección
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la dirección.
     *
     * @param street la nueva dirección
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Devuelve el estado.
     *
     * @return el estado
     */
    public String getState() {
        return state;
    }

    /**
     * Establece el estado.
     *
     * @param state el nuevo estado
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Devuelve el código ZIP.
     *
     * @return el código ZIP
     */
    public int getZip() {
        return zip;
    }

    /**
     * Establece el código ZIP.
     *
     * @param zip el nuevo código ZIP
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Devuelve el número de teléfono.
     *
     * @return el número de teléfono
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece el número de teléfono.
     *
     * @param phone el nuevo número de teléfono
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve el correo electrónico.
     *
     * @return el correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico.
     *
     * @param email el nuevo correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en cadena de la entrada de dirección.
     *
     * @return una cadena que contiene todos los campos de la entrada de dirección
     */
    @Override
    public String toString() {
        return "Nombre ='" + firstName + '\'' +
                ", Apellido='" + lastName + '\'' +
                ", Dirección ='" + street + '\'' +
                ", Estado ='" + state + '\'' +
                ", Código ZIP =" + zip +
                ", Teléfono ='" + phone + '\'' +
                ", Correo electrónico ='" + email + '\'';
    }
}
