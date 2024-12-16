package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.Model;
import com.example.java_proje_fx.model.Service;
import com.example.java_proje_fx.model.User;
import javafx.fxml.FXML;
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
    private VBox centerContainer;

    @FXML
    private BorderPane mainBorderPane;

    private Employee employee;

    @FXML
    private void onHasarlarClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/hasarlar.fxml"));

        Pane hasarlarContent = loader.load();
        mainBorderPane.setCenter(hasarlarContent);

//        Model ilk = new Model("Mercedes");
//
//        // Verileri servis katmanından çekiyoruz.
//        Service service = new Service("ave","marmara",ilk);

        //centerContainer.getChildren().setAll(hasarlarContent);

        HasarlarController  controller = loader.getController();
        controller.setEmployee(employee);
    }

    @FXML
    private void onRaporEkleClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/raporekle.fxml"));

        Pane raporContent = loader.load();

        mainBorderPane.setCenter(raporContent);

        //centerContainer.getChildren().setAll(raporContent);

    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}