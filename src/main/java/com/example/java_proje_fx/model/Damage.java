package com.example.java_proje_fx.model;

import java.util.UUID;

public class Damage extends Doc{
    private String id;
    public String damageDetails;
    public StatusType status;
    public Car car;

    public Damage(Customer user, String damageDetails, Car car) {
        super(user);
        status = StatusType.PENDING;
        this.id = UUID.randomUUID().toString();
        this.damageDetails = damageDetails;
        this.car = car;
    }

    public String getDamageDetails() {
        return damageDetails;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getId(){
        return this.id;
    }

    public Customer getCustomer(){
        if (this.user instanceof Customer) {
            return (Customer) this.user;
        }
        return null;
    }

    public Car getCar(){
        return this.car;
    }
}
