module com.example.studentsocietymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentsocietymanagementsystem to javafx.fxml;
    exports com.example.studentsocietymanagementsystem;
}