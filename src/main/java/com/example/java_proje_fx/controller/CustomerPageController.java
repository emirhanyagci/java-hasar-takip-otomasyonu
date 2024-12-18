package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerPageController {
    @FXML
    private TableView<Damage> customerTable;

    @FXML
    private TableColumn<Damage, String> carNameColumn;

    @FXML
    private TableColumn<Damage, String> detailsColumn;

    @FXML
    private TableColumn<Damage, String> raportColumn;

    @FXML
    private TableColumn<Damage, String> priceColumn;

    @FXML
    private TableColumn<Damage, String> stateColumn;

    private ObservableList<Damage> customerListesi = FXCollections.observableArrayList();

    public void initialize() {
        // Kolonlara özellik bağlama
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("damageDetails"));

        carNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getCar().getModel().getName()));
        detailsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDetails()));
        raportColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().get));
        priceColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getCar().get));
        stateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus()));

    }
}
