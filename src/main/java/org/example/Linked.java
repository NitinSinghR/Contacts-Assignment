package org.example;

import java.util.*;
import java.util.logging.*;

class Linked {
    Logger l = Logger.getLogger("com.api");
    Contacts rootNode = null;

    void addContact(String name, String number, String email) {
        Contacts newNode = new Contacts(name, number, email);
        if (rootNode == null) {
            this.rootNode = newNode;
            l.info("Added Successfully");
        } else {
            newNode.nextNode = rootNode;
            this.rootNode = newNode;
            l.info("Added Successfully");
        }
    }

    void deleteContact(String number) {
        if (Objects.equals(rootNode.number, number)) {
            rootNode = rootNode.nextNode;
            l.info("Removed Successfully");
        } else {
            Contacts temp = this.rootNode;
            while (temp.nextNode != null) {
                if (Objects.equals(temp.nextNode.number, number)) {
                    temp.nextNode = temp.nextNode.nextNode;
                }
                temp = temp.nextNode;
            }
        }
    }

    void searchContact(String number) {
        Contacts temp = this.rootNode;
        while (temp != null) {
            if (temp.number.equals(number)) {
                String s1 = " Name: " + temp.name + " number: " + number + " email " + temp.email;
                l.info(s1);
            }
            temp = temp.nextNode;
        }
    }

    void printContacts() {
        Contacts temp = this.rootNode;
        while (temp != null) {
            String s1 = " Name: " + temp.name + " number: " + temp.number + " email " + temp.email;
            l.info(s1);
            temp = temp.nextNode;
        }
    }

}
