package NetworkClasses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-18
 * Time: 13:30
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Result implements Serializable {
    List<Boolean> currentPlayerAnswers;
    List<Boolean> otherPlayerAnswers;
    int round;
    int currentPlayerScore;
    int otherPlayerScore;

    public Result(List<Boolean> currentPlayerAnswers, List<Boolean> otherPlayerAnswers,
                  int round, int currentPlayerScore, int otherPlayerScore) {
        this.currentPlayerAnswers = currentPlayerAnswers;
        this.otherPlayerAnswers = otherPlayerAnswers;
        this.round = round;
        this.currentPlayerScore = currentPlayerScore;
        this.otherPlayerScore = otherPlayerScore;
    }

    public List<Boolean> getCurrentPlayerAnswers() {
        return currentPlayerAnswers;
    }

    public List<Boolean> getOtherPlayerAnswers() {
        return otherPlayerAnswers;
    }

    public int getRound() {
        return round;
    }

    public int getCurrentPlayerScore() {
        return currentPlayerScore;
    }

    public int getOtherPlayerScore() {
        return otherPlayerScore;
    }
}
