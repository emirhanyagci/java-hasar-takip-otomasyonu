module com.example.java_proje_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxml to javafx.fxml;
    exports com.example.java_proje_fx;
    exports com.example.java_proje_fx.model;
}