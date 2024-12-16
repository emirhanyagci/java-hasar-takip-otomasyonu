package com.example.java_proje_fx.model;

import java.util.Date;
import java.util.UUID;

abstract public class Doc {
    String id;
    public Date createdAt;
    User user;

    public Doc(User user) {
        Date date = new Date();
        this.id= UUID.randomUUID().toString();
        this.user = user;
        this.createdAt = date;
    }
}
