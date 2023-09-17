module com.example.myfirstapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.myfirstapp to javafx.fxml;
    exports com.example.myfirstapp;
}