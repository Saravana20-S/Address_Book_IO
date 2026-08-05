package com.bridgelabz.advaddressbookio.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an Address Book that stores multiple contacts.
 */
public class AddressBook {

    // List to store all contact persons
    private final List<ContactPerson> contactList;

    /**
     * Initializes an empty Address Book.
     */
    public AddressBook() {
        this.contactList = new ArrayList<>();
    }
    
    /**
     * Adds a contact only if it does not already exist.
     *
     * @param contact Contact to be added
     */
    public void addContact(ContactPerson contact) {

        // Check for duplicate contact using Java Stream
        boolean isDuplicate = contactList.stream()
                .anyMatch(existingContact -> existingContact.equals(contact));

        if (isDuplicate) {
            System.out.println("\nDuplicate contact found. Contact was not added.");
            return;
        }

        contactList.add(contact);
        System.out.println("\nContact added successfully.");
    }


    /**
     * Edits an existing contact.
     * The contact is identified using first name and last name.
     * Only non-name fields can be modified.
     *
     * @param firstName First name of the contact
     * @param lastName Last name of the contact
     * @param address Updated address
     * @param city Updated city
     * @param state Updated state
     * @param zip Updated ZIP code
     * @param phoneNumber Updated phone number
     */
    public void editContact(String firstName,
                            String lastName,
                            String address,
                            String city,
                            String state,
                            String zip,
                            String phoneNumber) {

        // Search for the contact
        for (ContactPerson contact : contactList) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {

                // Update details except name
                contact.setAddress(address);
                contact.setCity(city);
                contact.setState(state);
                contact.setZip(zip);
                contact.setPhoneNumber(phoneNumber);

                System.out.println("\nContact updated successfully.");
                return;
            }
        }

        System.out.println("\nContact not found.");
    }

    /**
     * Displays all contacts in the address book.
     */
    public void displayContacts() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts found.");
            return;
        }

        System.out.println("\n========== CONTACT LIST ==========");

        for (ContactPerson contact : contactList) {
            System.out.println(contact);
            System.out.println("----------------------------------");
        }
    }

    /**
     * Deletes a contact from the address book.
     *
     * @param firstName First name
     * @param lastName Last name
     */
    public void deleteContact(String firstName, String lastName) {

        Iterator<ContactPerson> iterator = contactList.iterator();

        while (iterator.hasNext()) {

            ContactPerson contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {

                iterator.remove();

                System.out.println("\nContact deleted successfully.");
                return;
            }
        }

        System.out.println("\nContact not found.");
    }

    /**
     * Displays all contacts sorted alphabetically
     * by first name and then last name.
     */
    public void sortContactsByName() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts available.");
            return;
        }

        System.out.println("\n====== SORTED CONTACTS ======");

        contactList.stream()
                .sorted(Comparator
                        .comparing(ContactPerson::getFirstName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(ContactPerson::getLastName, String.CASE_INSENSITIVE_ORDER))
                .forEach(contact -> {
                    System.out.println(contact);
                    System.out.println("--------------------------------");
                });
    }


    /**
     * Displays contacts sorted alphabetically by city.
     */
    public void sortContactsByCity() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts available.");
            return;
        }

        System.out.println("\n====== CONTACTS SORTED BY CITY ======");

        contactList.stream()
                .sorted(Comparator.comparing(
                        ContactPerson::getCity,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    /**
     * Displays contacts sorted alphabetically by state.
     */
    public void sortContactsByState() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts available.");
            return;
        }

        System.out.println("\n====== CONTACTS SORTED BY STATE ======");

        contactList.stream()
                .sorted(Comparator.comparing(
                        ContactPerson::getState,
                        String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    /**
     * Displays contacts sorted by ZIP code.
     */
    public void sortContactsByZip() {

        if (contactList.isEmpty()) {
            System.out.println("\nNo contacts available.");
            return;
        }

        System.out.println("\n====== CONTACTS SORTED BY ZIP ======");

        contactList.stream()
                .sorted(Comparator.comparing(ContactPerson::getZip))
                .forEach(System.out::println);
    }
}