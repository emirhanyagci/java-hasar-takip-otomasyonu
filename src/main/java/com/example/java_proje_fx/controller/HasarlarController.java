package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import com.example.java_proje_fx.model.StatusType;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HasarlarController {

    @FXML
    private TableView<Damage> hasarTable;

    @FXML
    private TableColumn<Damage, String> idColumn;

    @FXML
    private TableColumn<Damage, String> detailsColumn;

    @FXML
    private TableColumn<Damage, String> statusColumn;

    @FXML
    private TableColumn<Damage, String> dateColumn;

    private ObservableList<Damage> hasarlarListesi = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        // Kolonlara özellik bağlama
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("damageDetails"));

        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId().toString()));

        detailsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDetails().toString()));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus().toString()));
        dateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(formatDate(cellData.getValue().createdAt)));

        // Test verileriyle tabloyu doldurma
        ObservableList<Damage> hasarlarListesi = FXCollections.observableArrayList(
                new Damage(null, "Arka tampon ezildi"),
                new Damage(null, "Sağ ön kapı çizik")
        );
        hasarTable.setItems(hasarlarListesi);
    }

    public void loadData(ArrayList<Damage> hasarList) {
        hasarlarListesi.setAll(hasarList);
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.format(date);
    }

    private void testData() {
        // Örnek veri ekleme
        Damage d1 = new Damage(null, "Arka tampon ezildi");
        Damage d2 = new Damage(null, "Sağ ön kapı çizik");
        d1.status = StatusType.ACCEPTED;
        d2.status = StatusType.COMPLETED;
        hasarlarListesi.add(d1);
        hasarlarListesi.add(d2);
    }
}
