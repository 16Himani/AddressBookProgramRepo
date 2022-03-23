package com.Infogalaxy;

import java.util.Scanner;

public class AddressBookMain {
        Scanner sc = new Scanner(System.in);
        Contact contact = new Contact();
        public void addContact(){
            System.out.println("Enter the First Name:");
            contact.setFirstName(sc.next());
            System.out.println("Enter the Last Name:");
            contact.setLastName(sc.next());
            System.out.println("Enter the Address:");
            contact.setAddress(sc.next());
            System.out.println("Enter the City:");
            contact.setCity(sc.next());
            System.out.println("Enter the State:");
            contact.setState(sc.next());
            System.out.println("Enter the zip:");
            contact.setZip(sc.next());
            System.out.println("Enter the Mobno:");
            contact.setMobNo(sc.next());
            System.out.println("Enter the Email");
            contact.setEmail(sc.next());



    }

    public void showContact(){
        System.out.println(contact.toString());

    }

    public void editContact(){
        System.out.println("Enter the FirstName :");
        String fname = sc.next();
        if(fname.equals(contact.getFirstName())) {
            System.out.println("Contact is Found..");
            System.out.println("Enter the Last Name:");
            contact.setLastName(sc.next());
            System.out.println("Enter the Address:");
            contact.setAddress(sc.next());
            System.out.println("Enter the City:");
            contact.setCity(sc.next());
            System.out.println("Enter the State:");
            contact.setState(sc.next());
            System.out.println("Enter the zip:");
            contact.setZip(sc.next());
            System.out.println("Enter the Mobno:");
            contact.setMobNo(sc.next());
            System.out.println("Enter the Email");
            contact.setEmail(sc.next());

        } else {
            System.out.println("Contact Not Found..");
        }
    }
    public static void main(String[] args) {
            AddressBookMain addressBookmain = new AddressBookMain();
            addressBookmain.addContact();
            addressBookmain.showContact();
            addressBookmain.editContact();
            addressBookmain.showContact();

    }
}
