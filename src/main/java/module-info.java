module com.cosenza {
    requires javafx.controls;
    requires javafx.fxml;
    requires v20;
    requires java.sql;


    opens com.cosenza to javafx.fxml;
    exports com.cosenza;
}