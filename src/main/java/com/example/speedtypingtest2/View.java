package com.example.speedtypingtest2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private Stage stage;
    private Controller controller;

    public View(Stage stage) {
        this.stage = stage;
        initialize();
    }

    private void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SpeedTypingTest.fxml"));
            VBox root = loader.load();
            controller = loader.getController();
            Scene scene = new Scene(root, 400, 400);
            stage.setTitle("Speed Typing Test");
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        stage.show();
    }

    public Controller getController() {
        return controller;
    }
}
