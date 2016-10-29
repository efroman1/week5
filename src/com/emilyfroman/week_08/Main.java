package com.emilyfroman.week_08;
import java.util.ArrayList;
import java.util.List;

class Contact{
    private String name;
    private String email;

    Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

class BusinessContact extends Contact{
    private String phoneNumber;

    BusinessContact(String name, String email, String phoneNumber) {
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Phone Number: " + phoneNumber);
    }
}

class AddressBook {
    List<Contact> contacts = new ArrayList<>();

    public void add(Contact c) {
        contacts.add(c);
    }

    public void display() {
        for (Contact c: contacts) {
            c.display(); // late binding
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Contact arthur = new Contact("Arthur", "aneuman1@cscc.edu");
        BusinessContact bob = new BusinessContact("Bob", "bob@email.com", "614-123-4567");
        AddressBook contacts = new AddressBook();
        contacts.add(arthur);
        contacts.add(bob);  // upcasting
        contacts.display();
    }
}