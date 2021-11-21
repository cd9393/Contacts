package com.company;

import java.time.LocalDate;
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
}
