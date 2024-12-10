package com.example.java_proje_fx.model;

import java.util.UUID;

public class Model {
    private String id;
    String name;

    public Model( String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
    public String getId(){
        return this.id;
    }
}
