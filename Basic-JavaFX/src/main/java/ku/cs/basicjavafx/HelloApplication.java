package ku.cs.basicjavafx;

import ku.cs.models.Identity;
import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Hello World");
        configRoute();
        //FXRouter.goTo("Identity-profile");
        FXRouter.goTo("Identity-list");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("Identity-profile", viewPath + "Identity.fxml");
        FXRouter.when("Identity-list",viewPath+"Identity-list.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}