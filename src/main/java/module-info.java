module com.example.java_proje_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_proje_fx.controller to javafx.fxml;
    exports com.example.java_proje_fx;
}
