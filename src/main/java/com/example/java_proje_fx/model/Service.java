package com.example.java_proje_fx.model;

import java.util.ArrayList;
import java.util.UUID;

public class Service {
    private String id;
    String name;
    String address;
    private Model expertModel;
    private ArrayList<Damage> damageDocs;
    private ArrayList<Raport> raportDocs;
    public Service(String name, String address, Model model) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.expertModel = model;
        this.damageDocs = new ArrayList<Damage>();
        this.raportDocs = new ArrayList<Raport>();

    }
    public String getId(){
        return this.id;
    }
    String getModelName(){
        return this.expertModel.name;
    }
    String getModelId(){
        return this.expertModel.getId();
    }
    void addDamageDoc(Damage damageDoc){
        damageDocs.add(damageDoc);
    }
    void listDamageDocs(){
        for(Damage damageDoc : damageDocs){
            System.out.println(damageDoc.damageDetails);
            System.out.println(damageDoc.status);

        }
    }
    void changeDamageDocStatus(User user, String docId, StatusType status){
        if(user.isEmployee()){
            for(Damage damageDoc : damageDocs){
                if(damageDoc.getId().equals(docId)){
                    damageDoc.status = status;
                }
            }
        }else{
            System.out.println("Sadece calisanlar bu islemi yapabilir");
        }
    }
    Raport createRaportDoc(User user, Damage damageDoc){
        if(user.isEmployee()){
            Raport raportDoc = new Raport(user,"Sag on far parca degisimi yapilmistir ve sag on kapi acilmama sorunu giderilmistir",0,damageDoc);
            raportDocs.add(raportDoc);
            return raportDoc;
        }else{
            System.out.println("Sadece calisanlar bu islemi yapabilir");
            return null;
        }

    }
}
