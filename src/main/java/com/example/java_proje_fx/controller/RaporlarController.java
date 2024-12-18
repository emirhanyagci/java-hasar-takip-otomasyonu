package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.Raport;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class RaporlarController {
    @FXML
    private TableView<Raport> raporTable;

    @FXML
    private TableColumn<Raport, String> customerColumn;

    @FXML
    private TableColumn<Raport, String> serviceMessageColumn;

    @FXML
    private TableColumn<Raport, String> priceColumn;

    @FXML
    private TableColumn<Raport, String> carNameColumn;

    @FXML
    private TableColumn<Raport, String> carYearColumn;

    @FXML
    private TableColumn<Raport, String> statusColumn;

    private ObservableList<Raport> raporlarListesi = FXCollections.observableArrayList();

    Employee employee;

    public void initialize() {

        customerColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getCustomer().getFirstName() + " " + cellData.getValue().getDamageDoc().getCustomer().getLastName()));

        serviceMessageColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().serviceMessage));

        priceColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPrice().toString()));

        carNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getCar().getModel().getName()));

        carYearColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getCar().getYear()));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getStatus().toString()));

        raporTable.setItems(raporlarListesi);

    }

    public void loadData(ArrayList<Raport> raporList) {
        raporlarListesi.setAll(raporList);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
