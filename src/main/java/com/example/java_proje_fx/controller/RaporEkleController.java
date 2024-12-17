package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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
    private TextField raporAdiField23;


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
}
