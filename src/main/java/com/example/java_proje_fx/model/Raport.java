package com.example.java_proje_fx.model;

public class Raport extends Doc{
    String serviceMessage;
    Damage damageDoc;
    int price;

    public Raport(User user, String serviceMessage, int price, Damage damageDoc) {
        super(user);
        this.serviceMessage = serviceMessage;
        this.price = price;
        this.damageDoc = damageDoc;
    }
}
