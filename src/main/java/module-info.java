module com.example.retoconjunto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.retoconjunto to javafx.fxml;
    exports com.example.retoconjunto;
}