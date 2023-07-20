package ku.cs.controllers;

import javafx.fxml.FXML;
import ku.cs.services.FXRouter;
import javafx.scene.control.Label;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    //@FXML
    //protected void onHelloButtonClick() {
    //    welcomeText.setText("Welcome to JavaFX Application!");
    //}

    @FXML
    protected void onHelloButtonClick() {
        try {
            FXRouter.goTo("student-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}