module org.example.java_test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Classes to javafx.fxml;
    exports Classes;




}