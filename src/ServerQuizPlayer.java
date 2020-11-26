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

    public void sendObject(Object object) throws IOException {

        objectOutputStream.writeObject(object);

    }

    public Object receiveAnswer() throws IOException, ClassNotFoundException {

        inputObject = objectInputStream.readObject();
        return inputObject;

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
