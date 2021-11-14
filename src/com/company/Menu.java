package com.company;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner;
    ContactBook contactBook;

    public Menu() {
        scanner = new Scanner(System.in);
        contactBook = new ContactBook();

    }

    public void displayMenu() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        String choice = this.scanner.nextLine();
        switch (choice) {
            case "add":
                addContact();
                break;
            case "remove":
                removeContact();
                break;
            case "edit":
                editContact();
                break;
            case "count":
                displayContactCount();
                break;
            case "list":
                displayContacts();
                break;
            case "exit":
                break;
            default :
                System.out.println("make a valid selection");
        }
    }

    public void displayContacts() {
        List<Contact> contacts = contactBook.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("The phone book has 0 records.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                String contactNumber = contact.hasNumber() ? contact.getPhoneNumber() : "[no number]";
                System.out.println(i+1 + ". " + contact.getName() + " " + contact.getSurname() + " " + contactNumber);
            }
        }
    }

    public void displayContactCount() {
        int contactCount = contactBook.getContacts().size();
        System.out.println("The Phone Book has " + contactCount + " records.");
    }

    public void removeContact() {
        displayContacts();
        System.out.println("Select a record:");
        int choice = Integer.parseInt(scanner.nextLine());
        contactBook.removeContact(choice);
    }

    public void addContact() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        Contact contact = new Contact(name, surname);
        contact.setPhoneNumber(number);
        System.out.println("The record added.");
    }

//    public void editContact() {
//        if (contactBook.getContacts().isEmpty()) {
//            System.out.println("No records to remove!");
//        } else {
//            displayContacts();
//            System.out.println("Select a record:");
//            int choice = Integer.parseInt(scanner.nextLine());
//
//        }
//    }


}
