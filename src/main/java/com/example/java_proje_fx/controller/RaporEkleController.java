package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.Raport;
import com.example.java_proje_fx.model.StatusType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


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

    @FXML
    private ChoiceBox<StatusType> statusChoiceBox;

    private Employee employee;

    private Damage damage;

    private HasarlarController hasarlarController;

    @FXML
    public void initialize() {
        statusChoiceBox.setItems(javafx.collections.FXCollections.observableArrayList(StatusType.values()));
        statusChoiceBox.setValue(StatusType.PENDING); // Varsayılan seçim
    }

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
        statusChoiceBox.setValue(damage.getStatus());
    }

    public void onRaporEkleKaydet() throws IOException {

         String raportDetail = raporAdiField24.getText();
         String  price = raporAdiField211.getText();

         damage.status = statusChoiceBox.getValue(); // Seçilen status'u güncelle

         employee.getService().createRaportDoc(employee, raportDetail, Integer.valueOf(price), damage);

         //dosya listelerini loglamak için
         employee.getService().listRaportDocs();
         employee.getService().listDamageDocs();

         Stage currentStage = (Stage) raporAdiField211.getScene().getWindow();
         currentStage.close();

        if (hasarlarController != null) {
            hasarlarController.refreshTable();
        }

    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public void setHasarlarController(HasarlarController hasarlarController) {
        this.hasarlarController = hasarlarController;
    }

}
