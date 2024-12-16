package com.example.java_proje_fx.model;

import java.util.UUID;

public class Damage extends Doc{
    private String id;
    String damageDetails;
    public StatusType status;
    public Damage(Customer user, String damageDetails) {
        super(user);
        status = StatusType.PENDING;
        this.id = UUID.randomUUID().toString();
        this.damageDetails = damageDetails;
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
}
