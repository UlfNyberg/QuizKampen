import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:33
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizServerListener {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(11111);

        while(true){
            QuizGame quizGame = new QuizGame();

            ServerQuizPlayer serverPlayerOne = new ServerQuizPlayer(serverSocket.accept(),quizGame);
            ServerQuizPlayer serverPlayerTwo = new ServerQuizPlayer(serverSocket.accept(),quizGame);

            serverPlayerOne.addOpponent(serverPlayerTwo);
            serverPlayerTwo.addOpponent(serverPlayerOne);

            serverPlayerOne.start();
            serverPlayerTwo.start();

        }
    }
}
