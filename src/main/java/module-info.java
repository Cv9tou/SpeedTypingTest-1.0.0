module com.example.speedtypingtest2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.speedtypingtest2 to javafx.fxml;
    exports com.example.speedtypingtest2;
}
