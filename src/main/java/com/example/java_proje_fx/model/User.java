package com.example.java_proje_fx.model;

import java.util.UUID;

abstract public class User {
    String id;
    String firstName;
    String lastName;
    String password;
    public User(String firstName, String lastName, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User() {
    }

    public boolean isEmployee(){
        return this instanceof Employee;
    }
    void userInfo(){
        System.out.println("Name:"+firstName+"Surname:"+lastName);
    }

    public boolean controlUser(String input_id,String input_password){
        return input_id.equals(this.id) && input_password.equals(this.password);
    }
}
