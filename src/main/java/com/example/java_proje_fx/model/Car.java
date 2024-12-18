package com.example.java_proje_fx.model;

import java.util.ArrayList;
import java.util.UUID;

public class Car {
    private String id;
    Model model;
    String name;
    String year;
    public ArrayList<Damage> carsDamageDocs;
    public ArrayList<Raport> carsRaportDocs;

    public void addDamageDoc(Damage damageDoc) {
        this.carsDamageDocs.add(damageDoc);
    }

    public void addRaportDocs(Raport raportDoc) {
        this.carsRaportDocs.add(raportDoc);
    }

    public Car(String name, String year, Model model){
        this.name = name;
        this.model = model;
        this.year = year;
        this.id = UUID.randomUUID().toString();
        this.carsDamageDocs = new ArrayList<Damage>();
        this.carsRaportDocs = new ArrayList<Raport>();
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
