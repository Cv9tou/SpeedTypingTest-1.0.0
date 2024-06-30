package com.example.speedtypingtest2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private TextArea textToTypeArea;

    @FXML
    private TextArea userInputArea;

    @FXML
    private TextArea botInputArea;

    @FXML
    private Label elapsedTimeLabel;

    @FXML
    private Label botTimeLabel;

    @FXML
    private Button startButton;

    @FXML
    private Button endButton;

    private final SpeedTypingTest speedTypingTest = new SpeedTypingTest();

    @FXML
    public void initialize() {

        textToTypeArea.textProperty().bindBidirectional(speedTypingTest.textToTypeProperty());
        userInputArea.textProperty().bindBidirectional(speedTypingTest.userInputProperty());
        botInputArea.textProperty().bindBidirectional(speedTypingTest.botInputProperty());


        userInputArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(speedTypingTest.getTextToType())) {
                speedTypingTest.endTyping();
                elapsedTimeLabel.setText("Your Time: " + speedTypingTest.getElapsedTime() + " ms");
            }
        });

        startButton.setOnAction(event -> startTyping());
        endButton.setOnAction(event -> endTyping());
    }

    private void startTyping() {
        speedTypingTest.setTextToType(speedTypingTest.getTextToType());
        speedTypingTest.startTyping();
        speedTypingTest.startBotTyping();
        elapsedTimeLabel.setText("Typing...");
        botTimeLabel.setText("Bot is typing...");
    }

    private void endTyping() {
        speedTypingTest.endTyping();
        elapsedTimeLabel.setText("Your Time: " + speedTypingTest.getElapsedTime() + " ms");
        botTimeLabel.setText("Bot Time: " + speedTypingTest.getBotElapsedTime() + " ms");
    }
}
