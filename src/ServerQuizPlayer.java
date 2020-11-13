import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

import java.io.*;
import java.net.Socket;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:59
 * Project: QuizKampen
 * Copyright: MIT
 */
public class ServerQuizPlayer extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private QuizGame quizGame;
    private ServerQuizPlayer opponent;
    private Object inputObject;
    private ObjectOutputStream objectOutputStream;

    public ServerQuizPlayer(Socket socket, QuizGame quizGame) {
        this.socket = socket;
        this.quizGame = quizGame;
        quizGame.addPlayer(this);

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("failed to create outputstream");
            e.printStackTrace();
        }

    }

    public void run() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            //TODO: kolla om initieringen blir i rätt ordning. vem börjar kommunikationen?

            while ((inputObject = objectInputStream.readObject()) != null) {
                if (inputObject instanceof Answer) {
                    quizGame.processInput(inputObject);
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot connect I/O");
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendQuestion(Question question){
        try {
            objectOutputStream.writeObject(question);
        } catch (IOException e) {
            System.out.println("Failed to send question");
            e.printStackTrace();
        }
    }

    public void addOpponent(ServerQuizPlayer opponent) {
        this.opponent = opponent;
    }
}
