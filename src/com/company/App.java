
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
        Menu menu = new Menu();
        menu.displayMenu();

    }


}