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
            System.out.println("player1 connected");
            ServerQuizPlayer serverPlayerTwo = new ServerQuizPlayer(serverSocket.accept(),quizGame);
            System.out.println("player2 connected");

            serverPlayerOne.addOpponent(serverPlayerTwo);
            serverPlayerTwo.addOpponent(serverPlayerOne);

            quizGame.start();
        }
    }
}
