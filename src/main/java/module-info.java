module com.example.bodyonfront {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.bodyonfront to javafx.fxml;
    exports com.example.bodyonfront;
    exports test.model.dao;
    exports model.domain;
}