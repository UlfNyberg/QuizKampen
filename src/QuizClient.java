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
public class QuizClient implements ActionListener {

    JFrame frame;
    JPanel cardPane;
    CardLayout card;

    private ObjectOutputStream out;
    private Socket socket;

    JPanel scene;
    GameBoardGUI gameBoardGUI;
    CategoryGUI categoryGUI;
    CurrentResultGUI currentResultGUI;
    HomescreenGUI homeScreenGUI;
    QuizClientPlayer clientListener;

    public QuizClient() {

        gameBoardGUI = new GameBoardGUI(this::actionPerformed);
        categoryGUI = new CategoryGUI(this::actionPerformed);
        currentResultGUI = new CurrentResultGUI(this::actionPerformed);
        homeScreenGUI = new HomescreenGUI(this::actionPerformed);

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

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == homeScreenGUI.initiateNewGameButton){
            socket = null;
            try {
                socket = new Socket(homeScreenGUI.IPAddressTextField.getText(),
                        Integer.parseInt(homeScreenGUI.portNrTextField.getText()));
                out = new ObjectOutputStream(socket.getOutputStream ());
                //clientListener = new QuizClientPlayer(socket);
                card.show(cardPane, "Gameboard Panel");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Kunde inte ansluta. Försök igen.");
            }
        }


    }

    public static void main(String[] args) {
        QuizClient quizclient = new QuizClient();
    }


}
