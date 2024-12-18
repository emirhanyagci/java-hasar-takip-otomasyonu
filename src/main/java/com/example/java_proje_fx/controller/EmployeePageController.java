package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.Model;
import com.example.java_proje_fx.model.Service;
import com.example.java_proje_fx.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class EmployeePageController {

    public TableView hasarTable;

    @FXML
    private Label servisAdi;

    @FXML
    private BorderPane mainBorderPane;

    private Employee employee;

    @FXML
    private void onHasarlarClicked() {
        try {
            // FXML dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/hasarlar.fxml"));
            VBox hasarlarContent = loader.load();

            // Controller'ı al ve çalışan bilgisini gönder
            HasarlarController controller = loader.getController();
            controller.setEmployee(employee);

            if (employee != null) {
                controller.loadData(employee.getService().getDamageDocs());
            }

            // Center bölgesine yerleştir
            mainBorderPane.setCenter(hasarlarContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onRaporlarClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/raporlar.fxml"));
        VBox raporlarContent = loader.load();

        RaporlarController controller = loader.getController();
        controller.setEmployee(employee);

        if (employee != null) {
            controller.loadData(employee.getService().getRaportDocs());
        }

        mainBorderPane.setCenter(raporlarContent);

    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
        servisAdi.setText(employee.getService().getExpertModel().getName() + " " + employee.getService().getName());
    }
}