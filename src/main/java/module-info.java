module com.example.ejemplocrud {
    requires javafx.controls;
    requires javafx.fxml;


    opens Controller to javafx.fxml;
    exports Controller;
    exports Model;
    opens Model to javafx.fxml;
}