
package com.company;

import java.util.Scanner;

public class App {

    ContactBook contactBook;
    Scanner scanner;

    public App() {
        this.contactBook = new ContactBook();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        createContact(scanner);
        System.out.println("A Phone Book with a single record created!");
    }

    private void createContact(Scanner scanner) {
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        this.contactBook.addContact(name, surname, number);
    }

}