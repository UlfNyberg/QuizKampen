package NetworkClasses;

import Util.GameRules;

import java.io.Serializable;

public class Init implements Serializable {

    protected String playerName;
    protected GameRules gameRules;

    public Init(String playerName, GameRules gameRules) {
        this.playerName = playerName;
        this.gameRules = gameRules;
    }

    public String getPlayerName(){
        return playerName;
    }
    public GameRules getGameRules(){ return gameRules; }
}
