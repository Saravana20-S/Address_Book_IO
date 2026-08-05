package com.bridgelabz.advaddressbookio.model;

import java.util.ArrayList;
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
     * Adds a new contact to the address book.
     *
     * @param contact ContactPerson object to be added
     */
    public void addContact(ContactPerson contact) {
        contactList.add(contact);
        System.out.println("\nContact added successfully.");
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
}