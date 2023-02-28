package org.example;

import java.util.*;
import java.util.logging.*;

class Contactlist {

    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        Contactsops c = new Contactsops();

        Logger l = Logger.getLogger("com.api.jar");

        while (true) {
            l.info("Enter your Choice\n1. Add contacts\n2.Remove Contact\n3.Search Contact\n4.Print Contacts");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    l.info("Enter the name");
                    String s1 = sc.next();
                    l.info("Enter the number of contact ");
                    String s2 = sc.next();
                    l.info("Enter the email");
                    String s3 = sc.next();
                    c.addElement(s1, s2, s3);
                }
                case 2 -> {
                    l.info("Enter the number to remove ");
                    String s2 = sc.next();
                    c.deleteElement(s2);
                }
                case 3 -> {
                    l.info("Enter the number to search ");
                    String s2 = sc.next();
                    c.searchElement(s2);
                }
                case 4 -> {
                    c.printElements();
                }
                default -> {
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
