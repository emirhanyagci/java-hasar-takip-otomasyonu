package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.StatusType;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    private TableColumn<Damage, String> customerIdColumn;

    @FXML
    private TableColumn<Damage, String> customerNameColumn;

    @FXML
    private TableColumn<Damage, String> carNameColumn;

    @FXML
    private TableColumn<Damage, String> carYearColumn;

    private ObservableList<Damage> hasarlarListesi = FXCollections.observableArrayList();

    Employee employee;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));

        detailsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDamageDetails()));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus().toString()));

        dateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(formatDate(cellData.getValue().createdAt)));

//        customerIdColumn.setCellValueFactory(cellData ->
//                new SimpleStringProperty(cellData.getValue().getCustomer().getId()));

        customerNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getFirstName() + cellData.getValue().getCustomer().getLastName()));

        carNameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getCar().getName()));

        carYearColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getCar().getYear()));

        //eğer yorum satırı olmazsa employee'nin verilerinin üstüne yazar, employee'ninkiler gözükmez
        // Test verileriyle tabloyu doldurma
//        ObservableList<Damage> hasarlarListesi = FXCollections.observableArrayList(
//                new Damage(null, "Arka tampon ezildi"),
//                new Damage(null, "Sağ ön kapı çizik")
//        );
        hasarTable.setItems(hasarlarListesi);
    }

    public void loadData(ArrayList<Damage> hasarList) {
        hasarlarListesi.setAll(hasarList);
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.format(date);
    }

    @FXML
    private void onRaporEkleClicked() throws IOException {
        // Tablo üzerinden seçili nesneye eriş
        Damage selectedDamage = hasarTable.getSelectionModel().getSelectedItem();

        // hasarlardan damage nesnesini al rapor ekleye o nesneyi at
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/raporekle.fxml"));
        Parent root = loader.load();
        RaporEkleController controller = loader.getController();
        controller.setEmployee(employee);

        if (selectedDamage != null) {
            // Yeni pencere aç ve detayları göster
            showRaporEkle(selectedDamage);
        } else {
            System.out.println("Lütfen bir satır seçin.");
        }
    }

    private void showRaporEkle(Damage damage) {
        try {
            // FXML dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fxml/raporekle.fxml"));
            Parent root = loader.load();

            // Controller'ı al ve veriyi ilet
            RaporEkleController controller = loader.getController();
            controller.setRaporEkle(damage);
            controller.setEmployee(employee);
            controller.setDamage(damage);
            controller.setHasarlarController(this); // HasarlarController referansını ilet

            // Yeni sahne oluştur
            Stage stage = new Stage();
            stage.setTitle("Hasar Detayları");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshTable() {
        if (employee != null) {
            hasarlarListesi.setAll(employee.getService().getDamageDocs());
            hasarTable.refresh();
        }
    }


    //deneme verileri oluşturucu
//    private void testData() {
//        // Örnek veri ekleme
//        Damage d1 = new Damage(null, "Arka tampon ezildi");
//        Damage d2 = new Damage(null, "Sağ ön kapı çizik");
//        d1.status = StatusType.ACCEPTED;
//        d2.status = StatusType.COMPLETED;
//        hasarlarListesi.add(d1);
//        hasarlarListesi.add(d2);
//    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
