
package com.company;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void removeContact(int choice) {
        this.contacts.remove(choice - 1);
        System.out.println("The record removed!");
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

}