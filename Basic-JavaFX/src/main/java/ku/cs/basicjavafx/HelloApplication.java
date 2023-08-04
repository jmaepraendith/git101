package ku.cs.basicjavafx;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
        // FXRouter.goTo("hello");
        FXRouter.goTo("Identity-table");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("Identity-profile", viewPath + "Identity.fxml");
        FXRouter.when("Identity-list",viewPath+"Identity-list.fxml");
        FXRouter.when("Identity-table", viewPath + "Identity-table.fxml");
        FXRouter.when("Identity-love", viewPath + "Identity-love.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}