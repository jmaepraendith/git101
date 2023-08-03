module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ku.cs.lab3modelclass to javafx.fxml;
    exports ku.cs.lab3modelclass;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;

    exports ku.cs.models;
    opens ku.cs.models to javafx.base;
}