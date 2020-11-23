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
    private ObjectInputStream objectInputStream;
    private String userName;

    public ServerQuizPlayer(Socket socket, QuizGame quizGame) {
        this.socket = socket;
        this.quizGame = quizGame;
        quizGame.addPlayer(this);

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("failed to create outputstream");
            e.printStackTrace();
        }

    }

    public void run() {

    }

    public void sendObject(Object object) {
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("Failed to send question");
            e.printStackTrace();
        }
    }

    public Object receiveAnswer() {

        try {
            inputObject = objectInputStream.readObject();
            return inputObject;

        } catch (IOException e) {
            System.out.println("Cannot connect I/O");
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(this.toString() + " failed to receive answer");
        return null;
    }

    public void addOpponent(ServerQuizPlayer opponent) {
        this.opponent = opponent;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
