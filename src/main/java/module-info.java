module com.example.smp_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.smp_4 to javafx.fxml;
    exports com.example.smp_4;
}