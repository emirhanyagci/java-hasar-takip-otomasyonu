package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("hasarDurumu"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("hasarAciklama"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("musteriAciklama"));
    }

    public void loadData(ArrayList<Damage> hasarList) {
        hasarTable.getItems().setAll(hasarList);
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
        updateUI(employee);
    }
    private void updateUI(Employee employee) {
        // Parametreleri FXML bileşenlerine yazdır
        if (this.employee != null) {
            List<Damage> hasarlarListesi = new ArrayList<>();
            hasarlarListesi = employee.getService().getDamageDocs();

            employee.getService().listDamageDocs();


            System.out.println("burasi    a");
            System.out.println(hasarlarListesi);

            ObservableList<Damage> observablePersonList = FXCollections.observableArrayList(hasarlarListesi);

            hasarTable.setItems(observablePersonList);
            // IDE ObservableList önerdi
        }
    }

}
