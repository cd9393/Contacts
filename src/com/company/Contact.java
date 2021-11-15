package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = "[no number]";
    }

    public String getName() {
        return name;
    }

    public boolean hasNumber() {
        return this.phoneNumber.isEmpty() ? false : true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
            System.out.println("Wrong number format!");
        }
    }

    private boolean isValidNumber(String phoneNumber) {
        Pattern phonePattern = Pattern.compile("\\+?" +
                "((\\([0-9A-Za-z]+\\)|[0-9A-Za-z]+)"
                + "|([0-9A-Za-z]+[ -]\\([0-9A-Za-z]{2,}\\))|[0-9A-Za-z]+[ -][0-9A-Za-z]{2,})"
                + "([ -][0-9A-Za-z]{2,}[ -]?)*");
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

        return phoneMatcher.matches();
    }
}