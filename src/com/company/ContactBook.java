
package com.company;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String surname,String number) {
        Contact contact = new Contact(name, surname, number);
        this.contacts.add(contact);
        System.out.println("A record was created!");
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

}