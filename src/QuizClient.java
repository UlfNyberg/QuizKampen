import QuestionsAndAnswers.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:32
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizClient {

    JFrame frame;
    JPanel cardPane;
    CardLayout card;

    private ObjectOutputStream out;
    private Socket socket;

    JPanel scene;
    GameBoardGUI gameBoardGUI = new GameBoardGUI();
    CategoryGUI categoryGUI = new CategoryGUI();
    CurrentResultGUI currentResultGUI = new CurrentResultGUI();
    HomescreenGUI homeScreenGUI = new HomescreenGUI();
    QuizClientPlayer clientListener;

    public QuizClient() {
        frame = new JFrame("Quiz Client");
        frame.setSize(400, 600);

        cardPane = new JPanel();




        card = new CardLayout();

        cardPane.setLayout(card);


        cardPane.add(homeScreenGUI, "Homescreen Panel");
        cardPane.add(categoryGUI, "Category Panel");
        cardPane.add(gameBoardGUI, "Gameboard Panel");
        cardPane.add(currentResultGUI, "Result Panel");




        frame.add(cardPane);
        //frame.add(scene);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }












    public static void main(String args[]) {

        QuizClient quizclient = new QuizClient();
    }


}

    /*
    public static void main(String[] args) {

        String hostName = "127.0.0.1"; //localhost
        int portNumber = 55555;

        try (
                Socket kkSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()))
        ) {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));

            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            e.printStackTrace();
            System.exit(1);
        }
    }

     */

