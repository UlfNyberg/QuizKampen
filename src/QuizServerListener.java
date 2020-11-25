import Util.GameRules;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:33
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizServerListener {

    public static void main(String[] args) throws IOException {
        GameRules gameRules = new GameRules();
        System.out.println("Ange portnummer");
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(scanner.nextInt());
        System.out.println("Server startad");
        while (true) {
            QuizGame quizGame = new QuizGame(gameRules);

            ServerQuizPlayer serverPlayerOne = new ServerQuizPlayer(serverSocket.accept(), quizGame);
            System.out.println("player1 connected");
            serverPlayerOne.setUserName("player1");
            ServerQuizPlayer serverPlayerTwo = new ServerQuizPlayer(serverSocket.accept(), quizGame);
            System.out.println("player2 connected");
            serverPlayerTwo.setUserName("player2");

            quizGame.start();
        }
    }
}
