package com.emilyfroman.week_09;

import java.util.ArrayList;
import java.util.List;

abstract class Contact {
    private String name;

    Contact(String name) {
        this.name = name;
    }

    abstract public void contact();
}

class EmailContact extends Contact {
    private String email;

    EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing " + email);
    }
}

class PhoneContact extends Contact {
    private String phoneNumber;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact(){
        System.out.println("Calling " + phoneNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneContact bob = new PhoneContact("Bob", "123-456-7890");
        EmailContact sue = new EmailContact("Sue", "sue@email.com");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(bob);
        contacts.add(sue);

        for (Contact c: contacts) {
            c.contact();
        }
    }
}