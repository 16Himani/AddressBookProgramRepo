package com.Infogalaxy;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public void addContact() {

        Contact contact = new Contact();
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
        contactArrayList.add(contact);
        System.out.println("Size of List:" + contactArrayList.size());


    }

    public void showContact() {
        try {
            for (int i = 0; i < contactArrayList.size(); i++) {
                Contact contact = contactArrayList.get(i);
                System.out.println(contact.toString());
            }
        } catch (NullPointerException npe) {
            System.out.println("Contact is Blank");
        }
    }

    public void editContact() {
        System.out.println("Enter the FirstName :");
        String fname = sc.next();
        int isAvailable = 0;
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
            if (fname.equals(contact.getFirstName())) {
                isAvailable = 1;
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
                break;

            }
        }
        if (isAvailable == 0) {
            System.out.println("Contact Not Found..");
        }
    }

    public void deleteContact() {
        System.out.println("Enter The First Name");
        String fname = sc.next();
        int isAvailable = 0;
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
        if (fname.equals(contact.getFirstName())) {
            isAvailable = 1;
            System.out.println("Contact Found");
            contactArrayList.remove(i);
            break;
        }
    }
    if(isAvailable ==0) {
        System.out.println("Contact Not Found");
    }

}

     public void backupToFile() {
         try {
             String contactData = null;
             for (int i = 0; i < contactArrayList.size(); i++) {
                 Contact contact = contactArrayList.get(i);
                 contactData = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," + contact.getCity() + ","
                         + contact.getState() + "," + contact.getZip() + "," + contact.getMobNo() + "," + contact.getEmail() + "\n" + contactData;
             }

             Path file = Paths.get("AddressBookMain.txt");
             byte[] byteData = contactData.getBytes();

             Files.write(file, byteData);


         } catch (IOException e) {
             e.printStackTrace();
         }
     }

       public void restoreFromFile() {
           contactArrayList.clear();
           try {
               String data;
               BufferedReader br = new BufferedReader(new FileReader("AddressBookMain"));
               while ((data = br.readLine()) != null && !data.equals("null")) {
                   String[] seperatedData = data.split(",");
                   Contact contact = new Contact();
                   contact.setFirstName(seperatedData[0]);
                   contact.setLastName(seperatedData[1]);
                   contact.setAddress(seperatedData[2]);
                   contact.setCity(seperatedData[3]);
                   contact.setState(seperatedData[4]);
                   contact.setZip(seperatedData[5]);
                   contact.setMobNo(seperatedData[6]);
                   contact.setEmail(seperatedData[7]);
                   contactArrayList.add(contact);
                   System.out.println("Contact Restore Sucessfully..");


               }


           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
       public static void main(String[] args) {
            AddressBookMain addressBookmain = new AddressBookMain();
            int choice;
            do {
                System.out.println("*****ADDRESS BOOK MANAGER*****");
                System.out.println("1. ADD CONTACT \n2. EDIT CONTACT \n3. DELETE CONTACT \n4. SHOW CONTACT \n5. BACKUP TO FILE \n6. RESTORE FROM FILE");
                System.out.println(" Enter the Operation No :");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addressBookmain.addContact();
                        break;

                    case 2:
                        addressBookmain.editContact();
                        break;

                    case 3:
                        addressBookmain.deleteContact();
                        break;

                    case 4:
                        addressBookmain.showContact();
                        break;

                    case 5:
                        addressBookmain.backupToFile();
                        break;

                    case 6:
                        addressBookmain.restoreFromFile();
                        break;
                }
            } while (choice != 7);
    }
}
