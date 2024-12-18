package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Raport;
import com.example.java_proje_fx.model.Service;
import com.example.java_proje_fx.model.StatusType;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class CustomerPageController {
    @FXML
    private TableView<Raport> customerTable;

    @FXML
    private TableColumn<Raport, String> carNameColumn;

    @FXML
    private TableColumn<Raport, String> detailsColumn;

    @FXML
    private TableColumn<Raport, String> raportColumn;

    @FXML
    private TableColumn<Raport, String> priceColumn;

    @FXML
    private TableColumn<Raport, String> stateColumn;

    private ObservableList<Raport> raportListesi = FXCollections.observableArrayList();


    public Raport damage;

    public void initialize() {
        // Kolonlara özellik bağlama
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("damageDetails"));

        carNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getCar().getName()));
        detailsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getDamageDetails()));
        raportColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().serviceMessage));
        priceColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPrice().toString()));
        stateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDoc().getStatus().toString()));

        customerTable.setItems(raportListesi);


    }

    public void loadRaportDocsData(ArrayList<Raport> raports) {
        raportListesi.setAll(raports);
    }

}
