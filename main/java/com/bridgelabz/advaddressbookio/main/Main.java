package com.bridgelabz.advaddressbookio.main;

import com.bridgelabz.advaddressbookio.model.AddressBook;
import com.bridgelabz.advaddressbookio.model.ContactPerson;
import com.bridgelabz.advaddressbookio.service.CsvFileService;
import com.bridgelabz.advaddressbookio.service.JsonFileService;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point of the Advanced Address Book application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        JsonFileService jsonService = new JsonFileService();
        CsvFileService csvService = new CsvFileService();

        int choice;

        do {

            System.out.println("\n========= ADDRESS BOOK =========");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Sort By Name");
            System.out.println("4. Sort By City");
            System.out.println("5. Sort By State");
            System.out.println("6. Sort By ZIP");
            System.out.println("7. View Persons By City");
            System.out.println("8. View Persons By State");
            System.out.println("9. Search Person By City");
            System.out.println("10. Search Person By State");
            System.out.println("11. Write Contacts to JSON");
            System.out.println("12. Read Contacts from JSON");
            System.out.println("13. Write Contacts to CSV");
            System.out.println("14. Read Contacts from CSV");
            System.out.println("15. Exit");
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
                    addressBook.sortContactsByName();
                    break;

                case 4:
                    addressBook.sortContactsByCity();
                    break;

                case 5:
                    addressBook.sortContactsByState();
                    break;

                case 6:
                    addressBook.sortContactsByZip();
                    break;

                case 7:
                    System.out.println("\nThank you for using Address Book.");
                    break;

                case 8:

                    System.out.print("Enter City: ");
                    String cityy = scanner.nextLine();

                    addressBook.viewPersonsByCity(cityy);
                    break;

                case 9:

                    System.out.print("Enter City: ");
                    String searchCity = scanner.nextLine();

                    addressBook.searchPersonByCity(searchCity);
                    break;

                case 10:

                    System.out.print("Enter State: ");
                    String searchState = scanner.nextLine();

                    addressBook.searchPersonByState(searchState);
                    break;


                    //Gson already used
                case 11:

                    jsonService.writeContacts(addressBook.getContactList());

                    break;

                case 12:

                    List<ContactPerson> contacts =
                            jsonService.readContacts();

                    if (contacts.isEmpty()) {

                        System.out.println("\nNo contacts found.");

                    } else {

                        System.out.println("\n===== CONTACTS FROM JSON =====");

                        contacts.forEach(System.out::println);
                    }

                    break;

                case 13:

                    csvService.writeContacts(addressBook.getContactList());

                    break;

                case 14:

                    List<ContactPerson> contactss =
                            csvService.readContacts();

                    if (contactss.isEmpty()) {

                        System.out.println("\nNo contacts found.");

                    } else {

                        System.out.println("\n===== CONTACTS FROM CSV =====");

                        contactss.forEach(System.out::println);
                    }

                    break;

                case 15:

                    System.out.println("\nThank you for using Address Book.");

                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }

        } while (choice != 15);

        scanner.close();
    }
}