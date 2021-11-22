package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    protected String phoneNumber;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastUpdated;
    final boolean isPerson;

    public Contact(boolean isPerson) {
        this.phoneNumber = "[no number]";
        this.createdAt = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.isPerson = isPerson;

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
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
        this.lastUpdated = LocalDateTime.now();
    }
}