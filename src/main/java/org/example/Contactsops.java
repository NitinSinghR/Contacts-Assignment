package org.example;

import java.util.logging.*;

class Contactsops {
    Logger l = Logger.getLogger("com");
    Linked[] list = new Linked[10];

    void addElement(String name, String number, String email) {
        int ph = number.length();
        int index1 = Integer.parseInt(String.valueOf(number.charAt(0)));
        int index2 = Integer.parseInt(String.valueOf(number.charAt(ph - 1)));
        int index = (index1 + index2) % 10;
        if (list[index] == null) {
            list[index] = new Linked();
        }
        list[index].addContact(name, number, email);
    }

    void deleteElement(String number) {
        int ph = number.length();
        int index1 = Integer.parseInt("" + number.charAt(0));
        int index2 = Integer.parseInt("" + number.charAt(ph - 1));
        int index = (index1 + index2) % 10;
        if (list[index] == null) {
            l.info("Invalid Number");
        } else {
            list[index].deleteContact(number);
        }
    }

    void searchElement(String number) {
        int ph = number.length();
        int index1 = Integer.parseInt("" + number.charAt(0));
        int index2 = Integer.parseInt("" + number.charAt(ph - 1));
        int index = (index1 + index2) % 10;
        if (list[index] == null) {
            l.info("Invalid Number");
        } else {
            list[index].searchContact(number);
        }

    }

    void printElements() {
        for (int i = 0; i < 10; i++) {
            if (list[i] != null) {
                list[i].printContacts();
            }
        }
    }

}
