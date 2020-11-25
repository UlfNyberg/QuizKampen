package NetworkClasses;

import java.io.Serializable;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-25
 * Time: 13:22
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Winner implements Serializable {
    int round;

    public Winner(int round) {
        this.round = round;
    }
    public int getRound() {
        return round;
    }
}
