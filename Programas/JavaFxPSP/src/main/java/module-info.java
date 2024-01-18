module org.example.javafxpsp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxpsp to javafx.fxml;
    exports org.example.javafxpsp;
}