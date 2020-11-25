package NetworkClasses;

import java.io.Serializable;

public class Init implements Serializable {

    protected String playerName;

    public Init(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }
}
