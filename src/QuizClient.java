import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:32
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizClient implements Runnable, ActionListener {

    JFrame frame;
    JPanel cardPane;
    CardLayout card;

    private ObjectOutputStream out;
    private Socket socket;

    GameBoardGUI gameBoardGUI;
    CategoryGUI categoryGUI;
    CurrentResultGUI currentResultGUI;
    HomescreenGUI homeScreenGUI;
    boolean gameStarted = false;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer answer4;

    public QuizClient() {
        GameRules gameRules = new GameRules();
        gameBoardGUI = new GameBoardGUI(this);
        categoryGUI = new CategoryGUI(this);
        currentResultGUI = new CurrentResultGUI();
        homeScreenGUI = new HomescreenGUI(this);

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
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void run() {

        while (!gameStarted) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Object fromServer;

            while ((fromServer = in.readObject()) != null) {
                if(fromServer instanceof Category){
                    card.show(cardPane,"Category Panel");
                    categoryGUI.category1Button.setText(((Category) fromServer).category1);
                    categoryGUI.category2Button.setText(((Category) fromServer).category2);
                }
                if (fromServer instanceof Question) {
                    card.show(cardPane, "Gameboard Panel");
                    gameBoardGUI.questionTextArea.setText(((Question) fromServer).getQuestion());
                    gameBoardGUI.alternative1.setText(((Question) fromServer).getAnswers().get(0).getText());
                    gameBoardGUI.alternative2.setText(((Question) fromServer).getAnswers().get(1).getText());
                    gameBoardGUI.alternative3.setText(((Question) fromServer).getAnswers().get(2).getText());
                    gameBoardGUI.alternative4.setText(((Question) fromServer).getAnswers().get(3).getText());
                    gameBoardGUI.categoryLabel.setText(((Question) fromServer).getCategory());
                    answer1 = ((Question) fromServer).getAnswers().get(0);
                    answer2 = ((Question) fromServer).getAnswers().get(1);
                    answer3 = ((Question) fromServer).getAnswers().get(2);
                    answer4 = ((Question) fromServer).getAnswers().get(3);

                } else if (fromServer instanceof Wait) {
                    card.show(cardPane, "Result Panel");
                } else if (fromServer  instanceof Result) {
                    List<Boolean> currentPlayer = ((Result) fromServer).currentPlayerAnswers;
                    List<Boolean> otherPlayer = ((Result) fromServer).otherPlayerAnswers;
                    int round = ((Result) fromServer).round;
                    int currentPlayerResult = ((Result) fromServer).currentPlayerScore;
                    gameBoardGUI.currentPointsPlayer1Label.setText(String.valueOf(currentPlayerResult));
                    currentResultGUI.currentPointsPlayer1Label.setText(String.valueOf(currentPlayerResult));
                    int otherPlayerResult = ((Result) fromServer).otherPlayerScore;
                    gameBoardGUI.currentPointsPlayer2Label.setText(String.valueOf(otherPlayerResult));
                    currentResultGUI.currentPointsPlayer2Label.setText(String.valueOf(otherPlayerResult));
                    SwingUtilities.invokeLater(() -> currentResultGUI.showResult(currentPlayer, otherPlayer, round));

                    card.show(cardPane, "Result Panel");
                }

            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == homeScreenGUI.initiateNewGameButton) {
            socket = null;
            try {
                socket = new Socket(homeScreenGUI.IPAddressTextField.getText(),
                        Integer.parseInt(homeScreenGUI.portNrTextField.getText()));
                out = new ObjectOutputStream(socket.getOutputStream());
                gameStarted = true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Kunde inte ansluta. Försök igen.");
            }
        } else if (ae.getSource() == gameBoardGUI.alternative1) {
            try {
                out.writeObject(answer1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == gameBoardGUI.alternative2) {
            try {
                out.writeObject(answer2);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == gameBoardGUI.alternative3) {
            try {
                out.writeObject(answer3);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == gameBoardGUI.alternative4) {
            try {
                out.writeObject(answer4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == categoryGUI.category1Button || ae.getSource() == categoryGUI.category2Button) {
            try {
                System.out.println("skickar category svar");
                out.writeObject(new Category(((JButton) ae.getSource()).getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new QuizClient());
        t.start();
    }


}
