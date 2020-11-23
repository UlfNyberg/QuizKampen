import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-17
 * Time: 13:27
 * Project: QuizKampen
 * Copyright: MIT
 */
public class GameRules {
    private static final Properties properties = new Properties();
    public static int numberOfQuestions;
    public static int numberOfRounds;

    GameRules() {
        try {
            properties.load(new FileInputStream("src/GameRules.properties"));
        } catch (IOException e) {
            System.out.println("Filen kunde inte hittas");
        }
        numberOfQuestions = Integer.parseInt(properties.getProperty("numberOfQuestions", "2"));
        numberOfRounds = Integer.parseInt(properties.getProperty("numberOfRounds", "3"));
    }
}
