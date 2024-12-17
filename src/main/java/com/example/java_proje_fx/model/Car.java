package com.example.java_proje_fx.model;

import java.util.UUID;

public class Car {
    private String id;
    Model model;
    String name;
    String year;
    public Car(String name, String year, Model model){
        this.name = name;
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

    public Model getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
