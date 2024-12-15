package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HasarlarController {
    @FXML
    private VBox centerContainer;

    @FXML
    private TableView<Damage> hasarTable;
    @FXML
    private TableColumn<Damage, Number> idColumn;
    @FXML
    private TableColumn<Damage, StatusType> statusColumn;
    @FXML
    private TableColumn<Damage, String> detailsColumn;
    @FXML
    private TableColumn<Damage, String> customerColumn;
    @FXML
    private TableColumn<Damage, Date> dateColumn;
    private Employee employee;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("hasarId"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("hasarTipi"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("hasarAciklama"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("musteriAciklama"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    }

    public void loadData(ArrayList<Damage> hasarList) {
        hasarTable.getItems().setAll(hasarList);
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
        updateUI();
    }
    private void updateUI() {
        // Parametreleri FXML bileşenlerine yazdır
        if (employee != null) {
            ObservableList<Damage> hasarlarListesi = (ObservableList<Damage>) employee.getService().getDamageDocs();
            hasarTable.setItems((ObservableList<Damage>) hasarlarListesi);
            // IDE ObservableList önerdi
        }
    }

}
