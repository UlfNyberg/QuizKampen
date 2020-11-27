import GUI.*;
import NetworkClasses.*;
import Util.GameRules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class QuizClient extends MouseAdapter implements Runnable, ActionListener {

    JFrame frame;
    JPanel cardPane;
    CardLayout card;

    private ObjectOutputStream out;
    private Socket socket;
    public GameRules gameRules;

    GameBoardGUI gameBoardGUI;
    CategoryGUI categoryGUI;
    CurrentResultGUI currentResultGUI;
    HomescreenGUI homeScreenGUI;
    WelcomeGUI welcomeGUI;
    boolean gameStarted = false;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer answer4;
    int height = 600;
    int width = 400;

    public QuizClient() {
        gameBoardGUI = new GameBoardGUI(this);
        categoryGUI = new CategoryGUI(this);
        currentResultGUI = new CurrentResultGUI();
        homeScreenGUI = new HomescreenGUI(this);
        welcomeGUI = new WelcomeGUI(this);

        frame = new JFrame("Quizkampen");
        frame.setSize(400, 640);
        frame.setResizable(false);

        cardPane = new JPanel();
        card = new CardLayout();
        cardPane.setLayout(card);

        cardPane.add(welcomeGUI, "Welcome Panel");
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
        while (!Thread.interrupted()) {
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

                    if (fromServer instanceof Init) {
                        String initName = ((Init) fromServer).getPlayerName();
                        GameRules gameRules = ((Init) fromServer).getGameRules();
                        if (initName == null) {
                            out.writeObject(new Init(homeScreenGUI.nameOfPlayerTextField.getText(), null));
                            this.gameRules = gameRules;
                            SwingUtilities.invokeLater(() -> currentResultGUI.setupUI(gameRules));
                            SwingUtilities.invokeLater(() -> categoryGUI.setupUI(gameRules));
                            if (gameRules.getNumberOfQuestions() == 4) {
                                width = 470;
                            } else if (gameRules.getNumberOfQuestions() == 5) {
                                width = 560;
                            }
                            if (gameRules.getNumberOfRounds() == 5) {
                                height = 700;
                            }
                            frame.setSize(width, height);
                        } else {
                            String currentPlayerName = homeScreenGUI.nameOfPlayerTextField.getText();
                            currentResultGUI.player1NameLabel.setText(currentPlayerName);
                            currentResultGUI.player2NameLabel.setText(initName);
                            gameBoardGUI.user1Label.setText(currentPlayerName);
                            gameBoardGUI.user2Label.setText(initName);
                        }
                    }

                    if (fromServer instanceof Category) {
                        card.show(cardPane, "Category Panel");
                        switch (gameRules.getNumberOfCategories()) {
                            case 2:
                                categoryGUI.category1Button.setText(((Category) fromServer).getCategory1());
                                categoryGUI.category2Button.setText(((Category) fromServer).getCategory2());
                                break;
                            case 3:
                                categoryGUI.category1Button.setText(((Category) fromServer).getCategory1());
                                categoryGUI.category2Button.setText(((Category) fromServer).getCategory2());
                                categoryGUI.category3Button.setText(((Category) fromServer).getCategory3());
                                break;
                            case 4:
                                categoryGUI.category1Button.setText(((Category) fromServer).getCategory1());
                                categoryGUI.category2Button.setText(((Category) fromServer).getCategory2());
                                categoryGUI.category3Button.setText(((Category) fromServer).getCategory3());
                                categoryGUI.category4Button.setText(((Category) fromServer).getCategory4());
                                break;
                        }
                    }
                    if (fromServer instanceof Question) {
                        card.show(cardPane, "Gameboard Panel");
                        gameBoardGUI.questionTextArea.setText("\n\n\n " + ((Question) fromServer).getQuestion());
                        gameBoardGUI.alternative1.setText(((Question) fromServer).getAnswers().get(0).getText());
                        gameBoardGUI.alternative2.setText(((Question) fromServer).getAnswers().get(1).getText());
                        gameBoardGUI.alternative3.setText(((Question) fromServer).getAnswers().get(2).getText());
                        gameBoardGUI.alternative4.setText(((Question) fromServer).getAnswers().get(3).getText());
                        gameBoardGUI.categoryLabel.setText(((Question) fromServer).getCategory());
                        answer1 = ((Question) fromServer).getAnswers().get(0);
                        answer2 = ((Question) fromServer).getAnswers().get(1);
                        answer3 = ((Question) fromServer).getAnswers().get(2);
                        answer4 = ((Question) fromServer).getAnswers().get(3);
                        gameBoardGUI.seconds = gameRules.getQuestionTimer();
                        gameBoardGUI.timerLabel.setText(gameBoardGUI.seconds + " sekunder kvar...");
                        gameBoardGUI.timer.start();

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
                    } else if (fromServer instanceof EndGame) {
                        resetGame(((EndGame) fromServer).getEndGameState().message);
                        break;
                    }
                }

            } catch (UnknownHostException e) {
                System.err.println("Don't know about host ");
                System.exit(1);
            } catch (SocketException e) {
                System.out.println("Socket Closed");
                resetGame("Tappade kontakten till servern");
                gameStarted = false;
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to ");
                e.printStackTrace();
                System.exit(1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetGame(String message) {
        JOptionPane.showMessageDialog(frame, message);
        gameStarted = false;
        SwingUtilities.invokeLater(() -> currentResultGUI.resetUI(gameRules.getNumberOfRounds()));
        height = 640;
        width = 400;
        frame.setSize(width, height);
        currentResultGUI.currentPointsPlayer1Label.setText("0");
        currentResultGUI.currentPointsPlayer2Label.setText("0");
        gameBoardGUI.currentPointsPlayer1Label.setText("0");
        gameBoardGUI.currentPointsPlayer2Label.setText("0");
        homeScreenGUI.initiateNewGameButton.setText("Starta nytt spel!");
        card.show(cardPane, "Homescreen Panel");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Color babyBlue = new Color(137, 207, 240);
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
                homeScreenGUI.initiateNewGameButton.setText("väntar på en till spelare...");
            } catch (IOException e) {
                System.out.println("Kunde inte ansluta. Försök igen.");
                homeScreenGUI.initiateNewGameButton.setText("Kunde inte ansluta. Försök igen");
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
            timedReset();
            timedSendAnswer(answer1);
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
            timedReset();
            timedSendAnswer(answer2);
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
            timedReset();
            timedSendAnswer(answer3);
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

            timedReset();
            timedSendAnswer(answer4);
        } else if (ae.getSource() == categoryGUI.category1Button || ae.getSource() == categoryGUI.category2Button
                || ae.getSource() == categoryGUI.category3Button || ae.getSource() == categoryGUI.category4Button) {
            try {
                System.out.println("skickar category svar");
                out.writeObject(new Category(((JButton) ae.getSource()).getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == gameBoardGUI.timer) {

            gameBoardGUI.seconds--;
            gameBoardGUI.timerLabel.setText(gameBoardGUI.seconds + " sekunder kvar...");

            if (gameBoardGUI.seconds <= 0) {
                disableButtonsOnClick();
                timedReset();
                timedSendAnswer(new Answer(""));
                if (answer1.isCorrect()) {
                    gameBoardGUI.alternative1.setBackground(babyBlue);
                } else if (answer2.isCorrect()) {
                    gameBoardGUI.alternative2.setBackground(babyBlue);
                } else if (answer3.isCorrect()) {
                    gameBoardGUI.alternative3.setBackground(babyBlue);
                } else if (answer4.isCorrect()) {
                    gameBoardGUI.alternative4.setBackground(babyBlue);
                }
            }


        }
    }

    private void timedReset() {
        Timer colorTimer = new Timer(1000, e -> {
            gameBoardGUI.alternative1.setBackground(Color.WHITE);
            gameBoardGUI.alternative2.setBackground(Color.WHITE);
            gameBoardGUI.alternative3.setBackground(Color.WHITE);
            gameBoardGUI.alternative4.setBackground(Color.WHITE);
        });
        colorTimer.setInitialDelay(1000);
        colorTimer.setRepeats(false);
        colorTimer.restart();
    }

    private void timedSendAnswer(Answer answer) {
        Timer answerTimer = new Timer(1000, e -> {
            try {
                out.writeObject(answer);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        answerTimer.setInitialDelay(1000);
        answerTimer.setRepeats(false);
        answerTimer.restart();
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
        gameBoardGUI.timer.stop();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new QuizClient());
        t.start();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == welcomeGUI) {
            card.show(cardPane, "Homescreen Panel");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == welcomeGUI) {
            welcomeGUI.add(welcomeGUI.panel2);
            welcomeGUI.panel.setVisible(false);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == welcomeGUI) {
            welcomeGUI.panel.setVisible(true);
        }
    }
}
