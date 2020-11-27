package NetworkClasses;

import java.io.Serializable;

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
