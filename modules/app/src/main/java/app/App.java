package app;

import amazing.AmazingService;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello from module " + App.class.getModule().getName());
        AmazingService.DEFAULT.compute();
        primaryStage.show();
    }
}
