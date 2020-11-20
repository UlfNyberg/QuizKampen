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

    public Result(List<Boolean> currentPlayerAnswers, List<Boolean> otherPlayerAnswers) {
        this.currentPlayerAnswers = currentPlayerAnswers;
        this.otherPlayerAnswers = otherPlayerAnswers;
    }
}
