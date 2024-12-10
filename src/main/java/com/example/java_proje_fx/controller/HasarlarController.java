package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Damage;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HasarlarController {

    @FXML
    private TableView<Damage> hasarTable;
    @FXML
    private TableColumn<Damage, Number> idColumn;
    @FXML
    private TableColumn<Damage, String> tipColumn;
    @FXML
    private TableColumn<Damage, String> aciklamaColumn;

}
