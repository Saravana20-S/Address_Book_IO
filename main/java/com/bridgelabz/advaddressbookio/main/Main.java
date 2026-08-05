package com.bridgelabz.advaddressbookio.main;

import com.bridgelabz.advaddressbookio.model.ContactPerson;

/**
 * Entry point of the Advanced Address Book application.
 */
public class Main {

    public static void main(String[] args) {

        // Create a sample contact
        ContactPerson contact = new ContactPerson(
                "Saravanan",
                "S",
                "12 MG Road",
                "Bengaluru",
                "Karnataka",
                "560001",
                "9876543210"
        );

        // Display contact details
        System.out.println(contact);
    }
}