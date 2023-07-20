module ku.cs.lab3modelclass {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ku.cs.lab3modelclass to javafx.fxml;
    exports ku.cs.lab3modelclass;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
}