package NetworkClasses;

import java.io.Serializable;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-27
 * Time: 11:09
 * Project: QuizKampen
 * Copyright: MIT
 */
public class EndGame implements Serializable {
    public enum EndGameStates {
        winner("Du vann!"),
        loser("Du förlorade"),
        draw("Det blev oavgjort"),
        disconnected("Din motståndare lämnade matchen");
        public final String message;
        EndGameStates(String message) {
            this.message = message;
        }
    }
    private EndGameStates endGameState;
    public EndGame(EndGameStates endGameStates) {
        this.endGameState = endGameStates;
    }

    public EndGameStates getEndGameState() {
        return endGameState;
    }
}
