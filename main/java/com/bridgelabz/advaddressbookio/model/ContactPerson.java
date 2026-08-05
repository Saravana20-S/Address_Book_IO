package com.bridgelabz.advaddressbookio.model;

import java.util.Objects;

/**
 * Model class representing a Contact Person in the Address Book.
 * This class stores all the personal details of a contact.
 */
public class ContactPerson {

    // Contact person's first name
    private String firstName;

    // Contact person's last name
    private String lastName;

    // Residential address
    private String address;

    // City name
    private String city;

    // State name
    private String state;

    // ZIP / Postal code
    private String zip;

    // Phone number
    private String phoneNumber;

    /**
     * Parameterized constructor.
     *
     * @param firstName First Name
     * @param lastName Last Name
     * @param address Address
     * @param city City
     * @param state State
     * @param zip ZIP Code
     * @param phoneNumber Phone Number
     */
    public ContactPerson(String firstName,
                         String lastName,
                         String address,
                         String city,
                         String state,
                         String zip,
                         String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Two ContactPerson objects are considered equal
     * if they have the same first name and last name.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        ContactPerson contact = (ContactPerson) obj;

        return firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName);
    }

    /**
     * Generates hash code based on first name and last name.
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(),
                lastName.toLowerCase()
        );
    }

    /**
     * Returns a formatted string representation of the contact.
     */
    @Override
    public String toString() {
        return "ContactPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}