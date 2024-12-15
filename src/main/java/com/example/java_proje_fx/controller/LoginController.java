package com.example.java_proje_fx.controller;

import com.example.java_proje_fx.model.Customer;
import com.example.java_proje_fx.model.Employee;
import com.example.java_proje_fx.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private static final HashMap<String, User> USERS = new HashMap<>();

    @FXML
    public void initialize() {
        // Kullanıcı adı kutusunda Enter tuşuna basıldığında şifre alanına geç
        usernameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });

        // Şifre kutusunda Enter tuşuna basıldığında giriş yap
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLoginButton();
            }
        });
    }
    static {
        USERS.put("employee1", new Employee("Emre", "Coruhlu", null));
        USERS.put("customer1", new Customer("Emirhan", "Yagci", null));
    }

    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = USERS.get(username);

        if (user != null && "12345".equals(password)) { // Şifre kontrolü basit bir şekilde yapılabilir
            if (user.isEmployee()) {
                openEmployeeBoard((Employee) user);
            } else {
                openCustomerBoard(user);
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Giriş Hatası", "Kullanıcı adı veya şifre yanlış.");
            usernameField.clear(); // Kullanıcı adı kutusunu temizle
            passwordField.clear(); // Şifre kutusunu temizle
            usernameField.requestFocus(); // Odaklanmayı geri al
        }
    }

    private boolean isValidUser(String username, String password) {
        // Bu kısmı bir veritabanı veya dosya okuma işlemiyle genişletebilirsiniz
        return "admin".equals(username) && "12345".equals(password);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void openEmployeeBoard(Employee employee) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fxml/employeepage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Controller'ı al ve kullanıcı bilgilerini gönder
            EmployeePageController controller = fxmlLoader.getController();
            controller.setEmployee(employee);

            controller.setEmployee(employee);

            Stage stage = new Stage();
            stage.setTitle("Çalışan Paneli");
            stage.setScene(scene);
            stage.show();

            // Mevcut pencereyi kapat
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openCustomerBoard(User user) {
    }
}
