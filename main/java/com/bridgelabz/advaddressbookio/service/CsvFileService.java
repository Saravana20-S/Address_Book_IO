package com.bridgelabz.advaddressbookio.service;

import com.bridgelabz.advaddressbookio.model.ContactPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for reading and writing
 * Address Book contacts as CSV files.
 */
public class CsvFileService {

    // CSV file location
    private static final String FILE_PATH =
            "src/main/resources/addressbook.csv";

    /**
     * Writes all contacts to the CSV file.
     *
     * @param contactList list of contacts
     */
    public void writeContacts(List<ContactPerson> contactList) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH))) {

            // Header
            writer.writeNext(new String[]{
                    "First Name",
                    "Last Name",
                    "Address",
                    "City",
                    "State",
                    "ZIP",
                    "Phone Number"
            });

            // Contact Records
            for (ContactPerson contact : contactList) {

                writer.writeNext(new String[]{
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber()
                });
            }

            System.out.println("\nContacts written to CSV successfully.");

        } catch (IOException exception) {

            System.out.println("Error writing CSV file : "
                    + exception.getMessage());
        }
    }

    /**
     * Reads all contacts from the CSV file.
     *
     * @return list of contacts
     */
    public List<ContactPerson> readContacts() {

        List<ContactPerson> contacts = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {

            List<String[]> rows = reader.readAll();

            // Skip Header
            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                ContactPerson contact = new ContactPerson(
                        row[0],
                        row[1],
                        row[2],
                        row[3],
                        row[4],
                        row[5],
                        row[6]
                );

                contacts.add(contact);
            }

        } catch (Exception exception) {

            System.out.println("Error reading CSV file : "
                    + exception.getMessage());
        }

        return contacts;
    }
}