package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.Raport;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RaporEkleController {

    @FXML
    private TextField raporAdiField;

    @FXML
    private TextField raporAdiField1;

    @FXML
    private TextField raporAdiField2;

    @FXML
    private TextField raporAdiField21;

    @FXML
    private TextField raporAdiField22;

    @FXML
    private TextField raporAdiField221;

    @FXML
    private TextField raporAdiField211;

    @FXML
    private TextField raporAdiField23;

    @FXML
    private TextField raporAdiField24;

    private Employee employee;

    private Damage damage;

    public void setRaporEkle(Damage damage) {
        // Hasar detaylarını etiketlere yazdır
        raporAdiField.setText(damage.getCustomer().getFirstName());
        raporAdiField1.setText(damage.getCustomer().getLastName());
        raporAdiField2.setText(damage.getCustomer().getId());
        raporAdiField21.setText(damage.getCustomer().getCar().getModel().getName());
        raporAdiField22.setText(damage.getCustomer().getCar().getYear());
        raporAdiField221.setText(damage.getCustomer().getCar().getModel().getId());
        raporAdiField23.setText(damage.getDamageDetails());
        //raporAdiField211.setText("Durum: " + damage.getCustomer().getId());
    }

    public void onRaporEkleKaydet(){

         String raportDetail = raporAdiField24.getText();
         String  price = raporAdiField211.getText();

         Raport raporDosyası = employee.getService().createRaportDoc(employee, raportDetail, Integer.valueOf(price), damage);
         employee.getService().listRaportDocs();
         Stage currentStage = (Stage) raporAdiField211.getScene().getWindow();
         currentStage.close();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setDamage(Damage damage) {
        this.damage = damage;
    }//    public void setDamage(Damage damage){
//        this.damage;
//    }
}
