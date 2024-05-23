module com.example.tpguide {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tpguide to javafx.fxml;
    exports com.example.tpguide;
}