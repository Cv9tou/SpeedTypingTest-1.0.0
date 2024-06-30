package com.example.speedtypingtest2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        View view = new View(primaryStage);
        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
