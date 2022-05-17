module com.example.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires com.google.gson;

    opens com.example.weatherapp to com.google.gson, javafx.fxml;
    exports com.example.weatherapp;
}