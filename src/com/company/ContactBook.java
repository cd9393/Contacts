
package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {

        this.contacts.add(contact);
        System.out.println("The record was added");
    }

    public List searchContacts(String searchStr) {
        Pattern searchQuery = Pattern.compile(".*" + searchStr + ".*", Pattern.CASE_INSENSITIVE);
        List<Contact> searchResult = new ArrayList<>();
        for (Contact contact : contacts) {
            List<Field> fields = contact.getAllFieldNames();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(contact);
                    if (null != fieldValue && searchQuery.matcher(fieldValue.toString()).matches()) {
                        searchResult.add(contact);
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return searchResult;
    }

    public void removeContact(int choice) {
        this.contacts.remove(choice - 1);
        System.out.println("The record removed!");
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }

}