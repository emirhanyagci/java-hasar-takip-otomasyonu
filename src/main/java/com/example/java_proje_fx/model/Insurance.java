package com.example.java_proje_fx.model;

import java.util.ArrayList;
import java.util.UUID;

public class Insurance {
    private String id;
    String name;
    private ArrayList <Service> services;
    private ArrayList<Customer> customers;
    public Insurance(String name) {
        services = new ArrayList<Service>();
        customers = new ArrayList<Customer>();
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    String getId(){
        // return id only for employees
        return this.id;
    }
    public void addServices(Service service){
        // check if there is same com.example.java_proje_fx.model service block to add new one
        services.add(service);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void listServices() {
        for (Service service : services)
            System.out.println(service.getModelName());
    }
    public Damage createDamageDoc(Customer user, String damageDetails, Car car){
        boolean isInInsurence = false;
        for ( Customer customer : customers){
            if (customer.getId().equals(user.getId())) isInInsurence = true;
        }
        if (!isInInsurence) return null;
        for (Service service : services) {
            if (service.getModelId().equals(user.getModelId())) {
                //Damage damageDoc = new Damage(user, "Arabanin sag on fari calismiyor ve sag on kapi sıkısmıs acılmıyor");
                Damage damageDoc = new Damage(user, damageDetails, car);
                service.addDamageDoc(damageDoc);
                car.addDamageDoc(damageDoc);
                return damageDoc;
            }
        }
        return null;
    }
}
