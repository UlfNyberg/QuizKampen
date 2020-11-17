import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:32
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizClient implements ActionListener {

    JFrame frame;
    JPanel cardPane;
    CardLayout card;

    GameBoardGUI gameBoardGUI;
    CategoryGUI categoryGUI;
    CurrentResultGUI currentResultGUI;
    HomescreenGUI homeScreenGUI;

    public QuizClient() {
        frame = new JFrame("Quiz Client");
        frame.setSize(400, 600);

        cardPane = new JPanel();


        homeScreenGUI.button5.addActionListener(this);  //fel? Nullpointer

        card = new CardLayout();

        cardPane.setLayout(card);

        cardPane.add(homeScreenGUI, "First Panel");
        cardPane.add(categoryGUI, "Second Panel");
        cardPane.add(gameBoardGUI, "Third Panel");
        cardPane.add(currentResultGUI, "Fourth Panel");

        frame.add(cardPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

                if (homeScreenGUI.button5.isSelected()){
                    //card.next(cardPane); //vilken blir rätt?
                    card.equals(categoryGUI);
                }

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

