package com.company;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Person extends Contact {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public Person() {
        super(true);
    }

    public String getName() {
        return name;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDay){
        try {
            LocalDate birthday = LocalDate.parse(birthDay);
            this.birthDate = birthday;
        } catch(DateTimeParseException e) {
            System.out.println("Bad Birth Date!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if ("M".equals(gender) || "F".equals(gender)) {
            this.gender = gender;
        }else {
            System.out.println("Bad Gender!");
        }
    }


    @Override
    public String getValueOfField(String fieldName) {
        switch (fieldName) {
            case "name":
                return this.name;
            case "surname":
                return this.surname;
            case "phoneNumber":
                return this.getPhoneNumber();
            case "gender":
                return this.gender;
            case "birthDate":
                return this.birthDate.toString();
            default:
                return "Not a valid field";
        }
    }

    @Override
    public void setFieldByName(String fieldName, String newValue) {
        switch (fieldName) {
            case "name":
                setName(newValue);
                break;
            case "surname":
                setSurname(newValue);
                break;
            case "phoneNumber":
                this.setPhoneNumber(newValue);
                break;
            case "gender":
                this.setGender(newValue);
                break;
            case "birthDate":
                this.setBirthDate(newValue);
                break;
            default:
                break;
        }
    }
}
