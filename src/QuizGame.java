import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class QuizGame extends Thread {

    private Socket playerOne;
    private Socket playerTwo;

    public void addPlayerOne(Socket playerOne){
        this.playerOne = playerOne;
    }

    public void addPlayerTwo(Socket playerTwo){
        this.playerTwo = playerTwo;
    }

    @Override
    public void run() {

    }
}
