import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class QuizGame extends Thread {

    private static final int WAITING = 0;
    private static final int SENTRIDDLE = 1;
    private static final int SENTANSWER = 2;

    private int state = WAITING;
    private int currentRiddle = 0;

    private String[] clues = { "Vad har fjädrar och fyra ben, men kan varken gå eller flyga?",
            "Känd artist som kunde mycket om ström?", "Hur gjorde man pannkakor i fängelset?"};
    private String[] answers = { "En säng",
            "Elvis",
            "Med en fånge som smet",};

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING || state == SENTANSWER) {
            theOutput = clues[currentRiddle];
            state = SENTRIDDLE;
        } else if (state == SENTRIDDLE) {
            if (theInput.equalsIgnoreCase(answers[currentRiddle])) {
                theOutput = "Rätt!";
            } else {
                theOutput = "Fel!";
            } state = SENTANSWER;
            currentRiddle++;
        }
        return theOutput;
    }
}
