package com.example.java_proje_fx;

import com.example.java_proje_fx.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Insurance alianz = new Insurance("Alianz");
        Model bmw = new Model("BMW");
        Car i8 = new Car("I8 Premium",2024,bmw);
        Customer emirhan = new Customer("Emirhan","Yagci",i8);
        alianz.addCustomer(emirhan);
        Service bostanci_servis = new Service("Bostanci Servis","Değirmenyolu Cad. No:23 34752\n" +
                "İçerenköy - Ataşehir, İstanbul", bmw);

        Employee emre = new Employee("Emre","Coruhlu",bostanci_servis);
        alianz.addServices(bostanci_servis);
        Damage hasar = alianz.createDamageDoc(emirhan);
        bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.ACCEPTED);
        bostanci_servis.listDamageDocs();
        bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.COMPLETED);
        Raport rapor = bostanci_servis.createRaportDoc(emre,hasar);
        System.out.println(rapor.serviceMessage);
        bostanci_servis.listDamageDocs();


    }
}