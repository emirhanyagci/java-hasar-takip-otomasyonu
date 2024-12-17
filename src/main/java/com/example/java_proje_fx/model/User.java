package com.example.java_proje_fx.model;

import java.util.UUID;

abstract public class User {
    String id;
    String firstName;
    String lastName;
    public User(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public boolean isEmployee(){
        return this instanceof Employee;
    }
    void userInfo(){
        System.out.println("Name:"+firstName+"Surname:"+lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
