package com.example.java_proje_fx.model;

public class Raport extends Doc{
    public String serviceMessage;
    Damage damageDoc;
    Integer price;

    public Raport(User user, String serviceMessage, Integer price, Damage damageDoc) {
        super(user);
        this.serviceMessage = serviceMessage;
        this.price = price;
        this.damageDoc = damageDoc;

    }

    public Employee getEmployee() {
        return getEmployee();
    }

    public String getServiceMessage() {
        return serviceMessage;
    }

    public Damage getDamageDoc() {
        return damageDoc;
    }

    public Integer getPrice() {
        return price;
    }

    public Raport getRaportDocFromDamageDoc(Damage damage){
        if(getEmployee().getService().getCar(damageDoc).equals(damage.getCar())){
            return getEmployee().getService().getRaportDoc(damage);
        }
        return null;
    }
}
