package com.bridgelabz.advaddressbookio.main;

import com.bridgelabz.advaddressbookio.model.AddressBook;
import com.bridgelabz.advaddressbookio.model.ContactPerson;

import java.util.Scanner;

/**
 * Entry point of the Advanced Address Book application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create an AddressBook object
        AddressBook addressBook = new AddressBook();

        System.out.println("===== Add New Contact =====");

        // Read contact details from the user
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter ZIP Code: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Create ContactPerson object
        ContactPerson contact = new ContactPerson(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phoneNumber
        );

        // Add contact to AddressBook
        addressBook.addContact(contact);

        // Display all contacts
        addressBook.displayContacts();

        scanner.close();
    }
}