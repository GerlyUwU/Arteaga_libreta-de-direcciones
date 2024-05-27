package com.libreta.addressData;

/**
 * Class representing an address entry in the address book.
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
     * Default constructor.
     */
    public AddressEntry() {
    }

    /**
     * Parameterized constructor to initialize all fields.
     *
     * @param firstName the first name of the contact
     * @param lastName the last name of the contact
     * @param street the street address of the contact
     * @param state the state of the contact
     * @param zip the ZIP code of the contact
     * @param phone the phone number of the contact
     * @param email the email address of the contact
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
     * Sets the ZIP code.
     *
     * @param zip the new ZIP code
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Sets the phone number.
     *
     * @param phone the new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the email address.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the street address.
     *
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     *
     * @param street the new street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code.
     *
     * @return the ZIP code
     */
    public int getZip() {
        return zip;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of the address entry.
     *
     * @return a string containing all fields of the address entry
     */
    @Override
    public String toString() {
        return "First name ='" + firstName + '\'' +
               ", last name='" + lastName + '\'' +
               ", street ='" + street + '\'' +
               ", state ='" + state + '\'' +
               ", zip =" + zip +
               ", phone ='" + phone + '\'' +
               ", email ='" + email + '\'';
    }
}
