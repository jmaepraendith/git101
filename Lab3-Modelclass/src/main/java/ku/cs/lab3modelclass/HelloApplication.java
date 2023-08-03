package ku.cs.lab3modelclass;

import ku.cs.services.FXRouter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.stage.Stage;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
        // FXRouter.goTo("hello");
        FXRouter.goTo("students-table");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("student-list", viewPath + "student-list.fxml");
        FXRouter.when("students-table", viewPath + "students-table.fxml");
        FXRouter.when("student-score", viewPath + "student-score.fxml");
    }

    @FXML
    protected void onHelloButtonClick() {
        try {
            FXRouter.goTo("student-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }


}

