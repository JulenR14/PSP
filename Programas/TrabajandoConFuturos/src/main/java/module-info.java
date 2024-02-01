module org.example.trabajandoconfuturos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens org.example.trabajandoconfuturos to javafx.fxml;
    exports org.example.trabajandoconfuturos;
}