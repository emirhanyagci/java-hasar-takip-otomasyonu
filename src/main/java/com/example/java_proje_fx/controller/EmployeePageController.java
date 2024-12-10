package com.example.java_proje_fx.controller;

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

    @FXML
    private void onHasarlarClicked() throws IOException {
        Parent hasarlarContent = FXMLLoader.load(getClass().getResource("hasarlar.fxml"));
        centerContainer.getChildren().setAll(hasarlarContent);
    }

    @FXML
    private void onRaporEkleClicked() throws IOException {
        Parent raporContent = FXMLLoader.load(getClass().getResource("raporekle.fxml"));
        centerContainer.getChildren().setAll(raporContent);
    }
}