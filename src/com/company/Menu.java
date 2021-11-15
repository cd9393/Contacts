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
        boolean isRunning = true;
        while(isRunning) {
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
                    isRunning = false;
                    break;
                default :
                    System.out.println("make a valid selection");
            }
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
                System.out.println(i+1 + ". " + contact.getName() + " " + contact.getSurname() + ", " + contactNumber);
            }
        }
    }

    public void displayContactCount() {
        int contactCount = contactBook.getContacts().size();
        System.out.println("The Phone Book has " + contactCount + " records.");
    }

    public void removeContact() {
        if (contactBook.getContacts().isEmpty()) {
            displayContacts();
        } else {
            displayContacts();
            System.out.println("Select a record:");
            int choice = Integer.parseInt(scanner.nextLine());
            contactBook.removeContact(choice);
        }
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
        contactBook.addContact(contact);
        System.out.println("The record added.");
    }

    public void editContact() {
        if (contactBook.getContacts().isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            displayContacts();
            System.out.println("Select a record:");
            int choice = Integer.parseInt(scanner.nextLine());
            Contact contact = contactBook.getContacts().get(choice - 1);
            System.out.println("Select a field (name, surname, number):");
            String fieldName = scanner.nextLine();
            switch (fieldName) {
                case "name":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    contact.setName(name);
                    System.out.println("The record updated!");
                    break;
                case "surname":
                    System.out.println("Enter surname");
                    String surname = scanner.nextLine();
                    contact.setSurname(surname);
                    System.out.println("The record updated!");
                    break;
                case "number":
                    System.out.println("Enter Number");
                    String number = scanner.nextLine();
                    contact.setPhoneNumber(number);
                    System.out.println("The record updated!");
                    break;
                default:
                    System.out.println("Make a valid selection");
                    break;
            }
        }
    }


}
