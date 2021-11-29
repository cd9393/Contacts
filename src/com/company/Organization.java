package com.company;

import java.lang.reflect.Field;

public class Organization extends Contact {
    String name;
    String address;

    public Organization() {
        super(false);
    }


    @Override
    public String getValueOfField(String fieldName) {
        switch (fieldName) {
            case "name":
                return this.name;
            case "address":
                return this.address;
            case "phoneNumber":
                return this.getPhoneNumber();
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
            case "address":
                setAddress(newValue);
                break;
            case "phoneNumber":
                this.setPhoneNumber(newValue);
                break;
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
