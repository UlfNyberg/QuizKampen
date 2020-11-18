import java.io.Serializable;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-18
 * Time: 13:50
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Init implements Serializable {
    int numberOfQuestions;
    int numberOfRounds;

    public Init(int numberOfQuestions, int numberOfRounds) {
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfRounds = numberOfRounds;
    }
}
