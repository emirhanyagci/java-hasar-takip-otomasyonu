package com.example.java_proje_fx;

import com.example.java_proje_fx.controller.LoginController;
import com.example.java_proje_fx.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    public static Service bostanci_servis;
    public static Employee emre;
    public static Customer emirhan;

    public static void main(String[] args) {
//        Insurance alianz = new Insurance("Alianz");
//        Model bmw = new Model("BMW");
//        Car i8 = new Car("I8 Premium",2024,bmw);
//
//        Customer emirhan = new Customer("Emirhan","Yagci",i8);
//
//        alianz.addCustomer(emirhan);
//        Service bostanci_servis = new Service("Bostanci Servis","Değirmenyolu Cad. No:23 34752\n" +
//                "İçerenköy - Ataşehir, İstanbul", bmw);
//
//        Employee emre = new Employee("Emre","Coruhlu",bostanci_servis);
//
//        alianz.addServices(bostanci_servis);
//        Damage hasar = alianz.createDamageDoc(emirhan);
//        bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.ACCEPTED);
//        bostanci_servis.listDamageDocs();
//        bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.COMPLETED);
//        Raport rapor = bostanci_servis.createRaportDoc(emre,hasar);
//        System.out.println(rapor.serviceMessage);
//        bostanci_servis.listDamageDocs();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fxml/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            LoginController loginController = fxmlLoader.getController();

            Insurance alianz = new Insurance("Alianz");
            Model bmw = new Model("BMW");
            Car i8 = new Car("I8 Premium","2024",bmw);

            Customer emirhan = new Customer("Emirhan","Yagci",i8);

            alianz.addCustomer(emirhan);
            Service bostanci_servis = new Service("Bostanci Servis","Değirmenyolu Cad. No:23 34752\n" +
                    "İçerenköy - Ataşehir, İstanbul", bmw);

            Employee emre = new Employee("Emre","Coruhlu",bostanci_servis);

            alianz.addServices(bostanci_servis);
            Damage hasar = alianz.createDamageDoc(emirhan);
            bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.ACCEPTED);
            bostanci_servis.listDamageDocs();
            bostanci_servis.changeDamageDocStatus(emre,hasar.getId(), StatusType.COMPLETED);
            Raport rapor = bostanci_servis.createRaportDoc(emre,hasar);
            System.out.println(rapor.serviceMessage);
            bostanci_servis.listDamageDocs();

            loginController.addUser("employee1", emre);
            loginController.addUser("customer1", emirhan);

            System.out.println(emre.getService().listDamageDocs());

            primaryStage.setTitle("Kullanıcı Girişi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorAndExit("Uygulama yüklenirken bir hata oluştu.");
        }
    }
    private void showErrorAndExit(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hata");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
