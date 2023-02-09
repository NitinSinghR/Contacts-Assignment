package org.example;

import java.util.*;
import java.util.logging.Logger;

public class Contacts {

    String name;
    String number;
    String email;
    Contacts nextNode;
    public Contacts(String name,String number,String email){
        this.name=name;
        this.email=email;
        this.number=number;
    }

}
class Contactsops{
    Logger l= Logger.getLogger("com.api.jar");
    Linked list[] = new Linked[10];
    void addElement(String name, String number, String email) {
        int ph = number.length();
        int index1 = Integer.parseInt(String.valueOf( number.charAt(0)));
        int index2 = Integer.parseInt(String.valueOf(number.charAt(ph - 1)));
        int index = (index1 + index2) % 10;
        if (list[index] == null) {
            list[index] = new Linked();
        }
        list[index].addContact(name, number, email);
    }
    void deleteElement(String number){
        int ph = number.length();
        int index1 = Integer.parseInt("" + number.charAt(0));
        int index2 = Integer.parseInt("" + number.charAt(ph - 1));
        int index = (index1 + index2) % 10;
        if(list[index]==null) {
            l.info("Invalid Number");
        }
        else {
            list[index].deleteContact(number);
        }

    }
    void searchElement(String number){
        int ph = number.length();
        int index1 = Integer.parseInt("" + number.charAt(0));
        int index2 = Integer.parseInt("" + number.charAt(ph - 1));
        int index = (index1 + index2) % 10;
        if(list[index]==null) {
            l.info("Invalid Number");
        }
        else {
            list[index].searchContact(number);
        }

    }
    void printElements(){
        for(int i=0;i<10;i++){
            if(list[i]!=null){
                list[i].printContacts();
            }
        }
    }

}
class Linked{
    Logger l= Logger.getLogger("com.api.jar");
        Contacts rootNode=null;
    void addContact(String name, String number, String email){
        Contacts newNode=new Contacts(name, number, email);
        if(rootNode==null){
            this.rootNode=newNode;
            l.info("Added Successfully");
        }
        else{
            newNode.nextNode=rootNode;
            this.rootNode=newNode;
            l.info("Added Successfully");
        }
    }

    void deleteContact( String number){
        if(Objects.equals(rootNode.number, number)){
            rootNode=rootNode.nextNode;
            l.info("Removed Successfully");
         }else{
            Contacts temp=this.rootNode;
            while(temp.nextNode!=null){
                if(Objects.equals(temp.nextNode.number, number)){
                    temp.nextNode=temp.nextNode.nextNode;
                }
                temp=temp.nextNode;
                }
            }
        }

    void searchContact(String number){
        Contacts temp=this.rootNode;
        while (temp!=null) {
            if(temp.number.equals(number)){
                String s1=" Name: "+temp.name+" number: "+number+" email "+temp.email;
                l.info(s1);
            }temp=temp.nextNode;
        }
        }
        void printContacts(){
            Contacts temp=this.rootNode;
            while (temp != null) {
                String s1=" Name: "+temp.name+" number: "+temp.number+" email "+temp.email;
                l.info(s1);
                temp=temp.nextNode;
            }
        }

    }
class Contactlist{


    public static void main(String[] args) {
        int ch;
        Scanner sc=new Scanner(System.in);
        Contactsops c=new Contactsops();
        Logger l= Logger.getLogger("com.api.jar");
        while(true) {
            l.info("Enter your Choice\n1. Add contacts\n2.Remove Contact\n3.Search Contact\n4.Print Contacts");
            ch= sc.nextInt();
            switch (ch) {
                case 1 -> {
                    l.info("Enter the name");
                    String s1 = sc.next();
                    l.info("Enter the number");
                    String s2 = sc.next();
                    l.info("Enter the email");
                    String s3 = sc.next();
                    c.addElement(s1, s2, s3);
                }
                case 2 -> {
                    l.info("Enter the number");
                    String s2 = sc.next();
                    c.deleteElement(s2);
                }
                case 3 -> {
                    l.info("Enter the number");
                    String s2 = sc.next();
                    c.searchElement(s2);
                }
                case 4 -> {
                    c.printElements();
                    break;
                }
                default -> {
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}