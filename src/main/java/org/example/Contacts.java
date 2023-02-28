package org.example;

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

