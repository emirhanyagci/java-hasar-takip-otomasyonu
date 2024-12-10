package com.example.java_proje_fx.controller;

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

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

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


    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidUser(username, password)) { // Doğrulama metodu
            User user = new User(username, "admin@example.com");
            user.notEkle("ilk");
            openUserboard(user);
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


    private void openUserboard(User user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Controller'ı al ve kullanıcı bilgilerini gönder
            UserboardController controller = fxmlLoader.getController();
            controller.setUser(user);

            Stage stage = new Stage();
            stage.setTitle("userboard");
            stage.setScene(scene);
            stage.show();

            // Mevcut pencereyi kapat
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
