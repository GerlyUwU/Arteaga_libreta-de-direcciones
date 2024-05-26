package com.libreta.addressData;

public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String state;
    private int zip;
    private String phone;
    private String email;

    public AddressEntry() {

    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "" +
                "First name ='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", street ='" + street + '\'' +
                ", state ='" + state + '\'' +
                ", zip =" + zip +
                ", phone ='" + phone + '\'' +
                ", email ='" + email + '\'';
    }

}
