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

        AddressBook addressBook = new AddressBook();

        // ---------------- Add Contact ----------------

        System.out.println("===== Add Contact =====");

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

        ContactPerson contact = new ContactPerson(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phoneNumber
        );

        addressBook.addContact(contact);

        // ---------------- Edit Contact ----------------

        System.out.println("\n===== Edit Contact =====");

        System.out.print("Enter First Name of Contact: ");
        String editFirstName = scanner.nextLine();

        System.out.print("Enter Last Name of Contact: ");
        String editLastName = scanner.nextLine();

        System.out.print("Enter New Address: ");
        String newAddress = scanner.nextLine();

        System.out.print("Enter New City: ");
        String newCity = scanner.nextLine();

        System.out.print("Enter New State: ");
        String newState = scanner.nextLine();

        System.out.print("Enter New ZIP Code: ");
        String newZip = scanner.nextLine();

        System.out.print("Enter New Phone Number: ");
        String newPhone = scanner.nextLine();

        addressBook.editContact(
                editFirstName,
                editLastName,
                newAddress,
                newCity,
                newState,
                newZip,
                newPhone
        );

        // Display updated contacts
        addressBook.displayContacts();

        scanner.close();
    }
}