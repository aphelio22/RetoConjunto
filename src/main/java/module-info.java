module com.example.retoconjunto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.retoconjunto to javafx.fxml;
    exports com.example.retoconjunto;
    exports com.example.retoconjunto.controllers;
    opens com.example.retoconjunto.controllers to javafx.fxml;
}