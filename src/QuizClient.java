import GUI.CategoryGUI;
import GUI.CurrentResultGUI;
import GUI.GameBoardGUI;
import GUI.HomescreenGUI;
import NetworkClasses.*;
import Util.GameRules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
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

        frame = new JFrame("Quizkampen");
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

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

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

                if(fromServer instanceof Init){
                    String initName = ((Init) fromServer).getPlayerName();
                    if(initName == null){
                        out.writeObject(new Init(homeScreenGUI.nameOfPlayerTextField.getText()));
                    }else{
                        String currentPlayerName = homeScreenGUI.nameOfPlayerTextField.getText();
                        currentResultGUI.player1NameLabel.setText(currentPlayerName);
                        currentResultGUI.player2NameLabel.setText(initName);
                        gameBoardGUI.user1Label.setText(currentPlayerName);
                        gameBoardGUI.user2Label.setText(initName);
                    }
                }

                if (fromServer instanceof Category) {
                    card.show(cardPane, "Category Panel");
                    categoryGUI.category1Button.setText(((Category) fromServer).getCategory1());
                    categoryGUI.category2Button.setText(((Category) fromServer).getCategory2());
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
                } else if (fromServer instanceof Result) {
                    List<Boolean> currentPlayer = ((Result) fromServer).getCurrentPlayerAnswers();
                    List<Boolean> otherPlayer = ((Result) fromServer).getOtherPlayerAnswers();
                    int round = ((Result) fromServer).getRound();
                    int currentPlayerResult = ((Result) fromServer).getCurrentPlayerScore();
                    gameBoardGUI.currentPointsPlayer1Label.setText(String.valueOf(currentPlayerResult));
                    currentResultGUI.currentPointsPlayer1Label.setText(String.valueOf(currentPlayerResult));
                    int otherPlayerResult = ((Result) fromServer).getOtherPlayerScore();
                    gameBoardGUI.currentPointsPlayer2Label.setText(String.valueOf(otherPlayerResult));
                    currentResultGUI.currentPointsPlayer2Label.setText(String.valueOf(otherPlayerResult));
                    SwingUtilities.invokeLater(() -> currentResultGUI.showResult(currentPlayer, otherPlayer, round));

                    card.show(cardPane, "Result Panel");
                }

            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (SocketException e) {
            System.out.println("Socket Closed");
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
        Color babyBlue = new Color(137,207,240);
        Color correctAnswerColor = new Color(125, 255, 0);
        Color incorrectAnswerColor = new Color(255, 45, 33);
        if (ae.getSource() == homeScreenGUI.initiateNewGameButton) {
            socket = null;
            try {
                socket = new Socket(homeScreenGUI.ipAddressTextField.getText(),
                        Integer.parseInt(homeScreenGUI.portNrTextField.getText()));
                out = new ObjectOutputStream(socket.getOutputStream());
                gameStarted = true;
                System.out.println("Ansluten till servern");
            } catch (IOException e) {
                System.out.println("Kunde inte ansluta. Försök igen.");
            }
        } else if (ae.getSource() == gameBoardGUI.alternative1) {
            disableButtonsOnClick();
            if (answer1.isCorrect()) {
                gameBoardGUI.alternative1.setBackground(correctAnswerColor);
            } else {
                gameBoardGUI.alternative1.setBackground(incorrectAnswerColor);
                if (answer2.isCorrect()) {
                    gameBoardGUI.alternative2.setBackground(babyBlue);
                } else if (answer3.isCorrect()) {
                    gameBoardGUI.alternative3.setBackground(babyBlue);
                } else if (answer4.isCorrect()) {
                    gameBoardGUI.alternative4.setBackground(babyBlue);
                }
            }

            Timer t = new Timer(1000, e -> {
                gameBoardGUI.alternative1.setBackground(Color.WHITE);
                gameBoardGUI.alternative2.setBackground(Color.WHITE);
                gameBoardGUI.alternative3.setBackground(Color.WHITE);
                gameBoardGUI.alternative4.setBackground(Color.WHITE);
            });
            t.setInitialDelay(1000);
            t.setRepeats(false);
            t.restart();
            Timer t2 = new Timer(1000, e -> {
                try {
                    out.writeObject(answer1);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            t2.setInitialDelay(1000);
            t2.setRepeats(false);
            t2.restart();
        } else if (ae.getSource() == gameBoardGUI.alternative2) {
            disableButtonsOnClick();
            if (answer2.isCorrect()) {
                gameBoardGUI.alternative2.setBackground(correctAnswerColor);
            } else {
                gameBoardGUI.alternative2.setBackground(incorrectAnswerColor);
                if (answer1.isCorrect()) {
                    gameBoardGUI.alternative1.setBackground(babyBlue);
                } else if (answer3.isCorrect()) {
                    gameBoardGUI.alternative3.setBackground(babyBlue);
                } else if (answer4.isCorrect()) {
                    gameBoardGUI.alternative4.setBackground(babyBlue);
                }
            }

            Timer t = new Timer(1000, e -> {
                gameBoardGUI.alternative1.setBackground(Color.WHITE);
                gameBoardGUI.alternative2.setBackground(Color.WHITE);
                gameBoardGUI.alternative3.setBackground(Color.WHITE);
                gameBoardGUI.alternative4.setBackground(Color.WHITE);
            });
            t.setInitialDelay(1000);
            t.setRepeats(false);
            t.restart();
            Timer t2 = new Timer(1000, e -> {
                try {
                    out.writeObject(answer2);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            t2.setInitialDelay(1000);
            t2.setRepeats(false);
            t2.restart();

        } else if (ae.getSource() == gameBoardGUI.alternative3) {
            disableButtonsOnClick();
            if (answer3.isCorrect()) {
                gameBoardGUI.alternative3.setBackground(correctAnswerColor);
            } else {
                gameBoardGUI.alternative3.setBackground(incorrectAnswerColor);
                if (answer1.isCorrect()) {
                    gameBoardGUI.alternative1.setBackground(babyBlue);
                } else if (answer2.isCorrect()) {
                    gameBoardGUI.alternative2.setBackground(babyBlue);
                } else if (answer4.isCorrect()) {
                    gameBoardGUI.alternative4.setBackground(babyBlue);
                }
            }

            Timer t = new Timer(1000, e -> {
                gameBoardGUI.alternative1.setBackground(Color.WHITE);
                gameBoardGUI.alternative2.setBackground(Color.WHITE);
                gameBoardGUI.alternative3.setBackground(Color.WHITE);
                gameBoardGUI.alternative4.setBackground(Color.WHITE);
            });
            t.setInitialDelay(1000);
            t.setRepeats(false);
            t.restart();
            Timer t2 = new Timer(1000, e -> {
                try {
                    out.writeObject(answer3);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            t2.setInitialDelay(1000);
            t2.setRepeats(false);
            t2.restart();

        } else if (ae.getSource() == gameBoardGUI.alternative4) {
            disableButtonsOnClick();
            if (answer4.isCorrect()) {
                gameBoardGUI.alternative4.setBackground(correctAnswerColor);
            } else {
                gameBoardGUI.alternative4.setBackground(incorrectAnswerColor);
                if (answer1.isCorrect()) {
                    gameBoardGUI.alternative1.setBackground(babyBlue);
                } else if (answer2.isCorrect()) {
                    gameBoardGUI.alternative2.setBackground(babyBlue);
                } else if (answer3.isCorrect()) {
                    gameBoardGUI.alternative3.setBackground(babyBlue);
                }
            }

            Timer t = new Timer(1000, e -> {
                gameBoardGUI.alternative1.setBackground(Color.WHITE);
                gameBoardGUI.alternative2.setBackground(Color.WHITE);
                gameBoardGUI.alternative3.setBackground(Color.WHITE);
                gameBoardGUI.alternative4.setBackground(Color.WHITE);
            });
            t.setInitialDelay(1000);
            t.setRepeats(false);
            t.restart();
            Timer t2 = new Timer(1000, e -> {
                try {
                    out.writeObject(answer4);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            t2.setInitialDelay(1000);
            t2.setRepeats(false);
            t2.restart();
        } else if (ae.getSource() == categoryGUI.category1Button || ae.getSource() == categoryGUI.category2Button) {
            try {
                System.out.println("skickar category svar");
                out.writeObject(new Category(((JButton) ae.getSource()).getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void disableButtonsOnClick() {
        gameBoardGUI.alternative1.setEnabled(false);
        gameBoardGUI.alternative2.setEnabled(false);
        gameBoardGUI.alternative3.setEnabled(false);
        gameBoardGUI.alternative4.setEnabled(false);
        Timer t = new Timer(1000, e -> {
            gameBoardGUI.alternative1.setEnabled(true);
            gameBoardGUI.alternative2.setEnabled(true);
            gameBoardGUI.alternative3.setEnabled(true);
            gameBoardGUI.alternative4.setEnabled(true);
        });
        t.setInitialDelay(1000);
        t.setRepeats(false);
        t.restart();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new QuizClient());
        t.start();
    }


}
