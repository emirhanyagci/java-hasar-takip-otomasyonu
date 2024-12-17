package com.example.java_proje_fx.model;

public class Employee extends User{
    private Service service;
    public Employee(String firstName, String lastName,Service service){
        super(firstName, lastName);
        this.service =service;
    }
    @Override
    public void userInfo(){
        // change service id with service name later
        System.out.println("Name:"+firstName+"\nSurname:"+lastName+ " and Working at " + service.name);

    }

    public Service getService() {
        return service;
    }
}
