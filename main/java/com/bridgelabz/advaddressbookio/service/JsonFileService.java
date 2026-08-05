package com.bridgelabz.advaddressbookio.service;

import com.bridgelabz.advaddressbookio.model.ContactPerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Service class for reading and writing contacts
 * to a JSON file.
 */
public class JsonFileService {

    // JSON file location
    private static final String FILE_PATH =
            "src/main/resources/addressbook.json";

    // Gson object with pretty printing enabled
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Writes all contacts to a JSON file.
     *
     * @param contactList List of contacts
     */
    public void writeContacts(List<ContactPerson> contactList) {

        try (FileWriter writer = new FileWriter(FILE_PATH)) {

            gson.toJson(contactList, writer);

            System.out.println("\nContacts written to JSON successfully.");

        } catch (IOException exception) {

            System.out.println("Error writing JSON file : "
                    + exception.getMessage());
        }
    }

    /**
     * Reads contacts from the JSON file.
     *
     * @return List of contacts
     */
    public List<ContactPerson> readContacts() {

        try (FileReader reader = new FileReader(FILE_PATH)) {

            Type listType =
                    new TypeToken<List<ContactPerson>>() {
                    }.getType();

            List<ContactPerson> contacts =
                    gson.fromJson(reader, listType);

            return contacts == null
                    ? Collections.emptyList()
                    : contacts;

        } catch (IOException exception) {

            System.out.println("Error reading JSON file : "
                    + exception.getMessage());

            return Collections.emptyList();
        }
    }

    public CompletableFuture<Void> writeContactsAsync(
            List<ContactPerson> contactList) {

        return CompletableFuture.runAsync(() ->
                writeContacts(contactList));
    }

    public CompletableFuture<List<ContactPerson>> readContactsAsync() {

        return CompletableFuture.supplyAsync(
                this::readContacts);
    }
}