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
                case "add" -> addContact();
                case "remove" -> removeContact();
                case "edit" -> editContact();
                case "count" -> displayContactCount();
                case "list" -> displayContacts();
                case "exit" -> isRunning = false;
                default -> System.out.println("make a valid selection");
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
                if (contact.isPerson) {
                    Person person = (Person) contact;
                    String contactNumber = contact.hasNumber() ? contact.getPhoneNumber() : "[no number]";
                    System.out.println(i+1 + ". " + person.getName() + " " + person.getSurname() + ", " + contactNumber);
                } else {

                }
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
        System.out.println("Enter the type (person, organization):");
        String choice = scanner.nextLine();
        if ("person".equals(choice)) {
            addPerson();
        } else if ("organization".equals(choice)) {
            addOrganization();
        } else {
            System.out.println("Bad choice!");
        }
    }

    public void addPerson() {
        Person person = new Person();
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        person.setName(name);
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        person.setSurname(surname);
        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        person.setBirthDate(birthDate);
        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        person.setGender(gender);
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        person.setPhoneNumber(number);
        contactBook.addContact(person);
    }

    public void addOrganization() {
        Organization organization = new Organization();
        System.out.println("Enter the organization name:");
        organization.setName(scanner.nextLine());
        System.out.println("Enter the address:");
        organization.setAddress(scanner.nextLine());
        System.out.println("Enter the number:");
        organization.setPhoneNumber(scanner.nextLine());
        contactBook.addContact(organization);
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
                case "name" -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    contact.setName(name);
                    System.out.println("The record updated!");
                }
                case "surname" -> {
                    System.out.println("Enter surname");
                    String surname = scanner.nextLine();
                    contact.setSurname(surname);
                    System.out.println("The record updated!");
                }
                case "number" -> {
                    System.out.println("Enter Number");
                    String number = scanner.nextLine();
                    contact.setPhoneNumber(number);
                    System.out.println("The record updated!");
                }
                default -> System.out.println("Make a valid selection");
            }
        }
    }


}
