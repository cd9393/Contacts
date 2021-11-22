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
            System.out.println("Enter action (add, remove, edit, count, info, exit):");
            String choice = this.scanner.nextLine();
            switch (choice) {
                case "add" -> addContact();
                case "remove" -> removeContact();
                case "edit" -> editContact();
                case "count" -> displayContactCount();
                case "info" -> displayInfo();
                case "exit" -> isRunning = false;
                default -> System.out.println("make a valid selection");
            }
            System.out.println();
        }
    }

    public void displayInfo() {
        displayContacts();
        System.out.println("Select a record:");
        int choice = Integer.parseInt(scanner.nextLine());
        Contact contact = contactBook.getContacts().get(choice - 1);
        if (contact.isPerson) {
            displayPerson((Person) contact);
        } else {
            displayOrganization((Organization) contact);
        }
    }
    public void displayPerson(Person person) {
        String birthDate = person.getBirthDate() == null ? "[no data]" : person.getBirthDate().toString();
        String gender = person.getGender() == null ? "[no data]" : person.getGender();
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Birth date: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + person.getPhoneNumber());
        System.out.println("Time created: " + person.getCreatedAt());
        System.out.println("Time last edit: " + person.getLastUpdated());
    }

    public void displayOrganization(Organization organization) {
        System.out.println("Organization name: " + organization.getName());
        System.out.println("Address: " + organization.getAddress());
        System.out.println("Number: " + organization.getPhoneNumber());
        System.out.println("Time created: " + organization.getCreatedAt());
        System.out.println("Time last edit: " + organization.getLastUpdated());
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
                    System.out.println(i+1 + ". " + person.getName() + " " + person.getSurname());
                } else {
                    Organization organization = (Organization) contact;
                    System.out.println(i+1 + ". " + organization.getName());
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
            System.out.println("No records to remove!");
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
            System.out.println("No records to edit!");
        } else {
            displayContacts();
            System.out.println("Select a record:");
            int choice = Integer.parseInt(scanner.nextLine());
            Contact contact = contactBook.getContacts().get(choice - 1);
            if (contact.isPerson) {
                editPerson((Person) contact);
            } else {
                editOrganization((Organization) contact);
            }
        }
    }

    public void editOrganization(Organization contact) {
        System.out.println("Select a field (name, number, address):");
        String fieldName = scanner.nextLine();
        switch (fieldName) {
            case "name" -> {
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                contact.setName(name);
                System.out.println("The record updated!");
            }
            case "number" -> {
                System.out.println("Enter Number");
                String number = scanner.nextLine();
                contact.setPhoneNumber(number);
                System.out.println("The record updated!");
            }
            case "address" -> {
                System.out.println("Enter address");
                String address = scanner.nextLine();
                contact.setAddress(address);
                System.out.println("The record updated!");
            }
            default -> System.out.println("Make a valid selection");
        }
    }

    public void editPerson(Person contact) {
        System.out.println("Select a field (name, surname, birth, gender, number):");
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
            case "birth" -> {
                System.out.println("Enter birth");
                String birthdate = scanner.nextLine();
                contact.setBirthDate(birthdate);
                System.out.println("The record updated!");
            }
            case "gender" -> {
                System.out.println("Enter gender");
                String gender = scanner.nextLine();
                contact.setGender(gender);
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
