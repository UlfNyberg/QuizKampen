package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-17
 * Time: 13:27
 * Project: QuizKampen
 * Copyright: MIT
 */
public class GameRules implements Serializable {
    private static Properties properties = new Properties();
    protected final int numberOfQuestions;
    protected final int numberOfRounds;
    protected final int numberOfCategories;
    protected final int questionTimer;

    public GameRules() {
        try {
            properties.load(new FileInputStream("src/Util/GameRules.properties"));
        } catch (IOException e) {
            System.out.println("Filen kunde inte hittas");
        }
        numberOfCategories = Math.min(Integer.parseInt(properties.getProperty("numberOfCategories", "2")), 4);
        numberOfQuestions = Math.min(Integer.parseInt(properties.getProperty("numberOfQuestions", "2")), 5);
        numberOfRounds = Math.min(Integer.parseInt(properties.getProperty("numberOfRounds", "3")),5);
        questionTimer = Math.max(Integer.parseInt(properties.getProperty("questionTimer", "10")), 5);
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }

    public int getQuestionTimer() {
        return questionTimer;
    }



}
