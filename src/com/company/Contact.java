package com.company;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    protected String phoneNumber;
    protected LocalDate createdAt;
    protected LocalDate lastUpdated;
    final boolean isPerson;

    public Contact(boolean isPerson) {
        this.phoneNumber = "[no number]";
        this.createdAt = LocalDate.now();
        this.lastUpdated = LocalDate.now();
        this.isPerson = isPerson;

    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public Contact() {
        this.phoneNumber = "[no number]";
        this.createdAt = LocalDate.now();
        this.lastUpdated = LocalDate.now();
    }

    public boolean hasNumber() {
        return this.phoneNumber.isEmpty() ? false : true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            setLastUpdated();
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

    protected void setLastUpdated() {
        this.lastUpdated = LocalDate.now();
    }
}