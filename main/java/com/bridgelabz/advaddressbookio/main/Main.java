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

        int choice;

        do {

            System.out.println("\n========= ADDRESS BOOK =========");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    // Read contact details
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

                    // Create Contact object
                    ContactPerson contact = new ContactPerson(
                            firstName,
                            lastName,
                            address,
                            city,
                            state,
                            zip,
                            phoneNumber
                    );

                    // Add contact
                    addressBook.addContact(contact);
                    break;

                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:
                    System.out.println("\nThank you for using Address Book.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }

        } while (choice != 3);

        scanner.close();
    }
}