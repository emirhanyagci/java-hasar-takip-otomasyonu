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

public class EmployeePageController {
    public TableView hasarTable;
    @FXML
    private VBox centerContainer;
    private Employee employee;

    @FXML
    private void onHasarlarClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/hasarlar.fxml"));
        Parent hasarlarContent = loader.load();
        HasarlarController controller = loader.getController();

        Model ilk = new Model("Mercedes");
        // Verileri servis katmanından çekiyoruz.
        Service service = new Service("ave","marmara",ilk);
        controller.loadData(service.getDamageDocs());

        centerContainer.getChildren().setAll(hasarlarContent);
    }

    @FXML
    private void onRaporEkleClicked() throws IOException {
        Parent raporContent = FXMLLoader.load(getClass().getResource("/com/example/fxml/raporekle.fxml"));
        centerContainer.getChildren().setAll(raporContent);
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}