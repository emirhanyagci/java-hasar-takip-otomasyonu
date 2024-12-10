package com.example.java_proje_fx.model;

import java.util.UUID;

public class Customer extends User {
    private String id;
    private Car car;
    public Customer(String firstName, String lastName,Car car){
        super(firstName,lastName);
        this.id = UUID.randomUUID().toString();
        this.car = car;
    }
    public String getId(){
        return this.id;
    }
    public String getModelId(){
        return this.car.getModelId();
    }
}
