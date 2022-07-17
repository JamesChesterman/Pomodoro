module com.example.pomodoroguitest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pomodoroguitest to javafx.fxml;
    exports com.example.pomodoroguitest;
}