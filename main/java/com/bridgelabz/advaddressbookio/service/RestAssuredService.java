package com.bridgelabz.advaddressbookio.service;

import com.bridgelabz.advaddressbookio.model.ContactPerson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RestAssuredService {

    private static final String BASE_URL =
            "http://localhost:3000";

    /**
     * Adds a contact to the JSON Server.
     *
     * @param contact Contact to add
     */
    public void addContact(ContactPerson contact) {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(contact)
                .when()
                .post(BASE_URL + "/contacts")
                .then()
                .statusCode(201);

        System.out.println("Contact added successfully.");
    }

    /**
     * Retrieves all contacts from the JSON Server.
     *
     * @return List of contacts
     */
    public List<ContactPerson> getContacts() {

        ContactPerson[] contacts =
                RestAssured
                        .given()
                        .when()
                        .get(BASE_URL + "/contacts")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ContactPerson[].class);

        return Arrays.asList(contacts);
    }


    public CompletableFuture<Void> addContactAsync(
            ContactPerson contact) {

        return CompletableFuture.runAsync(() ->
                addContact(contact));
    }

    public CompletableFuture<List<ContactPerson>> getContactsAsync() {

        return CompletableFuture.supplyAsync(
                this::getContacts);
    }
}