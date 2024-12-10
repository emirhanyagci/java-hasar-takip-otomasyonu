package com.example.java_proje_fx.model;

import java.util.UUID;

public class Car {
    private String id;
    Model model;
    String name;
    int year;
    public Car(String name,int year,Model model){
        this.model = model;
        this.year = year;
        this.id = UUID.randomUUID().toString();
    }
    String getId(){
        // return id only for employees
        return this.id;
    }
    String getModelId(){
        return this.model.getId();
    }

}
