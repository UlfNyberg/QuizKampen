package NetworkClasses;

import java.io.Serializable;

public class RoundReady implements Serializable {
    private int round;

    public RoundReady(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}
