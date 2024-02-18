module com.example.ejemplocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Controller to javafx.fxml;
    exports Controller;
    exports Model;
    opens Model to javafx.fxml;
}