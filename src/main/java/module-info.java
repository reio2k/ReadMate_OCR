module com.example.readmate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.readmate to javafx.fxml;
    exports com.example.readmate;
}