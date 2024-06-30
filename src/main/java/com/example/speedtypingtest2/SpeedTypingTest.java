package com.example.speedtypingtest2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

public class SpeedTypingTest {
    private final StringProperty textToType;
    private final StringProperty userInput;
    private final StringProperty botInput;
    private long startTime;
    private long endTime;
    private long botStartTime;
    private long botEndTime;

    private static final String[] SUBJECTS = {
            "The quick brown fox", "A curious cat", "The adventurous dog", "An old wise man", "A young child"
    };

    private static final String[] VERBS = {
            "jumps over", "runs through", "explores", "ponders about", "discovers"
    };

    private static final String[] OBJECTS = {
            "the lazy dog", "a dense forest", "an abandoned house", "a mysterious phenomenon", "an ancient artifact"
    };

    private static final String[] ADVERBS = {
            "quickly", "silently", "curiously", "carefully", "excitedly"
    };

    public SpeedTypingTest() {
        this.textToType = new SimpleStringProperty(generateRandomText());
        this.userInput = new SimpleStringProperty("");
        this.botInput = new SimpleStringProperty("");
    }

    private String generateRandomText() {
        Random rand = new Random();
        String subject = SUBJECTS[rand.nextInt(SUBJECTS.length)];
        String verb = VERBS[rand.nextInt(VERBS.length)];
        String object = OBJECTS[rand.nextInt(OBJECTS.length)];
        String adverb = ADVERBS[rand.nextInt(ADVERBS.length)];
        return subject + " " + verb + " " + object + " " + adverb + ".";
    }

    public StringProperty textToTypeProperty() {
        return textToType;
    }

    public String getTextToType() {
        return textToType.get();
    }

    public void setTextToType(String text) {
        this.textToType.set(text);
    }

    public StringProperty userInputProperty() {
        return userInput;
    }

    public String getUserInput() {
        return userInput.get();
    }

    public void setUserInput(String input) {
        this.userInput.set(input);
    }

    public StringProperty botInputProperty() {
        return botInput;
    }

    public String getBotInput() {
        return botInput.get();
    }

    public void setBotInput(String input) {
        this.botInput.set(input);
    }

    public void startTyping() {
        startTime = System.currentTimeMillis();
    }

    public void endTyping() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void startBotTyping() {
        botStartTime = System.currentTimeMillis();
        new Thread(() -> {
            StringBuilder botProgress = new StringBuilder();
            for (char c : getTextToType().toCharArray()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                botProgress.append(c);
                setBotInput(botProgress.toString());
            }
            botEndTime = System.currentTimeMillis();
        }).start();
    }

    public long getBotElapsedTime() {
        return botEndTime - botStartTime;
    }
}
