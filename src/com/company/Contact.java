package com.company;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.reflect.Modifier.isProtected;

public abstract class Contact {
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

    public abstract void setFieldByName(String fieldName, String newValue);

    public final List<Field> getAllFieldNames() {
        final List<Field> allFields = new ArrayList<>(30);
        Collections.addAll(allFields, getClass().getDeclaredFields());
        Class<?> currentClass = getClass().getSuperclass();
        while (null != currentClass) {
            final Field[] declaredFields = Arrays
                    .stream(currentClass.getDeclaredFields())
                    .filter(filed -> isProtected(filed.getModifiers()))
                    .toArray(Field[]::new);
            Collections.addAll(allFields, declaredFields);
            currentClass = currentClass.getSuperclass();
        }
        return allFields;
    }

    public abstract String getValueOfField(String fieldName);

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