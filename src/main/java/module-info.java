module com.appregistros.conexionbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.appregistros.conexionbd to javafx.fxml;
    opens com.appregistros.conexionbd.controller to javafx.fxml;
    opens com.appregistros.conexionbd.model to javafx.base, javafx.graphics;
    exports com.appregistros.conexionbd;
}