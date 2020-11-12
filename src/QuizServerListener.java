import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

        int portNumber = 55555;

        ServerSocket serverSocket = new ServerSocket(55555);

        while(true){
            final Socket clientSocket = serverSocket.accept();
            QuizHandler clientHandler = new QuizHandler(clientSocket);
            clientHandler.start();

        }


}}
