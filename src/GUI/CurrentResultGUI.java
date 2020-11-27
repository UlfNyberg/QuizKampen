package GUI;

import Util.GameRules;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:48
 * Project: QuizKampen
 * Copyright: MIT
 */
public class CurrentResultGUI extends JPanel {

    protected GameRules gameRules;

    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    JPanel firstPanel = new JPanel();
    JPanel gameNamePanel = new JPanel();
    JPanel playerInfoLongPanel = new JPanel();
    JPanel playerInfoSpaceFillerLongPanel = new JPanel();
    JPanel playerScorePanel = new JPanel();
    JPanel playerNamePanel = new JPanel();
    JPanel firstRoundLongPanel = new JPanel();
    JPanel secondRoundLongPanel = new JPanel();
    JPanel thirdRoundLongPanel = new JPanel();
    JPanel fourthRoundLongPanel = new JPanel();
    JPanel fifthRoundLongPanel = new JPanel();
    public JPanel[] roundLongPanelArray = {firstRoundLongPanel, secondRoundLongPanel, thirdRoundLongPanel,
            fourthRoundLongPanel, fifthRoundLongPanel};

    List<JPanel> currentPlayerQuestions = new ArrayList<>();
    List<JPanel> otherPlayerQuestions = new ArrayList<>();

    JPanel currentlyPlayingPanel = new JPanel();

    List<JPanel> spaceFillerList = new ArrayList<>();

    JLabel round1Label = new JLabel("Runda 1");
    JLabel round2Label = new JLabel("Runda 2");
    JLabel round3Label = new JLabel("Runda 3");
    JLabel round4Label = new JLabel("Runda 4");
    JLabel round5Label = new JLabel("Runda 5");

    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("Monospace", Font.BOLD, 30);
    Font font3 = new Font("SansSerif", Font.BOLD, 15);

    JLabel gameNameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);
    JLabel currentlyPlayingLabel = new JLabel("SPELAR");
    public JLabel player1NameLabel = new JLabel("Spelare1");
    public JLabel player2NameLabel = new JLabel("Spelare2");
    public JLabel currentPointsPlayer1Label = new JLabel("0");
    public JLabel currentPointsPlayer2Label = new JLabel("0");
    JLabel versusLabel = new JLabel("vs.");
    JLabel betweenLabel = new JLabel("-");
    JLabel questionMark1Label = new JLabel("?");
    JLabel questionMark2Label = new JLabel("?");
    JLabel questionMark3Label = new JLabel("?");

    Color lighterGray = new Color(238, 235, 235);
    Color correctAnswerColor = new Color(125, 255, 0);
    Color incorrectAnswerColor = new Color(255, 45, 33);

    public CurrentResultGUI() {
        for (int i = 0; i < 16; i++) {
            spaceFillerList.add(new JPanel());
        }
        gameNameLabel.setFont(font2);
        player1NameLabel.setFont(font1);
        player2NameLabel.setFont(font1);
        questionMark1Label.setFont(font1);
        questionMark2Label.setFont(font1);
        questionMark3Label.setFont(font1);
        round1Label.setFont(font3);
        round2Label.setFont(font3);
        round3Label.setFont(font3);
        round4Label.setFont(font3);
        round5Label.setFont(font3);
        firstPanel.setLayout(new GridLayout(7, 1));
        this.add(firstPanel);
        firstPanel.add(gameNamePanel);
        firstPanel.add(playerInfoLongPanel);
        firstPanel.add(firstRoundLongPanel);
        firstPanel.add(secondRoundLongPanel);
        firstPanel.add(thirdRoundLongPanel);
        firstPanel.add(fourthRoundLongPanel);
        firstPanel.add(fifthRoundLongPanel);
        gameNamePanel.setLayout(new GridLayout(1, 1));
        playerInfoLongPanel.setLayout(new BorderLayout());
        playerInfoLongPanel.add(playerNamePanel, BorderLayout.NORTH, SwingConstants.CENTER);
        playerNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        playerInfoLongPanel.add(playerScorePanel, BorderLayout.CENTER, SwingConstants.CENTER);
        playerScorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        playerInfoLongPanel.add(playerInfoSpaceFillerLongPanel, BorderLayout.SOUTH, SwingConstants.CENTER);
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 8, 22);
        firstRoundLongPanel.setLayout(layout);
        secondRoundLongPanel.setLayout(layout);
        thirdRoundLongPanel.setLayout(layout);
        fourthRoundLongPanel.setLayout(layout);
        fifthRoundLongPanel.setLayout(layout);
        gameNamePanel.add(gameNameLabel);
        playerNamePanel.add(spaceFillerList.get(0));
        playerNamePanel.add(player1NameLabel);
        playerNamePanel.add(spaceFillerList.get(1));
        spaceFillerList.get(1).add(versusLabel);
        playerNamePanel.add(player2NameLabel);
        playerNamePanel.add(spaceFillerList.get(2));
        playerScorePanel.add(spaceFillerList.get(3));
        playerScorePanel.add(currentPointsPlayer1Label);
        playerScorePanel.add(spaceFillerList.get(4));
        spaceFillerList.get(4).add(betweenLabel);
        playerScorePanel.add(currentPointsPlayer2Label);
        playerScorePanel.add(spaceFillerList.get(5));

        panel3.setBackground(Color.PINK);
        panel4.setBackground(Color.PINK);
        spaceFillerList.get(0).setBackground(Color.PINK);
        spaceFillerList.get(1).setBackground(Color.PINK);
        spaceFillerList.get(2).setBackground(Color.PINK);
        spaceFillerList.get(3).setBackground(Color.PINK);
        spaceFillerList.get(4).setBackground(Color.PINK);
        spaceFillerList.get(5).setBackground(Color.PINK);
        gameNamePanel.setBackground(Color.PINK);
        currentlyPlayingPanel.setBackground(Color.PINK);
        playerNamePanel.setBackground(Color.PINK);
        playerScorePanel.setBackground(Color.PINK);
        playerInfoLongPanel.setBackground(Color.PINK);
        playerInfoSpaceFillerLongPanel.setBackground((Color.PINK));
        firstRoundLongPanel.setBackground(lighterGray);
        firstRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        secondRoundLongPanel.setBackground(lighterGray);
        secondRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        thirdRoundLongPanel.setBackground(lighterGray);
        thirdRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fourthRoundLongPanel.setBackground(lighterGray);
        fourthRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fifthRoundLongPanel.setBackground(lighterGray);
        fifthRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        currentlyPlayingPanel.setPreferredSize(new Dimension(120, 35));
        for (int i = 6; i < spaceFillerList.size(); i++) {
            spaceFillerList.get(i).setBackground(lighterGray);
        }
        setVisible(true);

    }

    public void setupUI(GameRules gameRules) {

        this.gameRules = gameRules;

        for (int j = 0; j < gameRules.getNumberOfQuestions(); j++) {
            JPanel thisQuestion = new JPanel();
            thisQuestion.setPreferredSize(new Dimension(35, 35));
            thisQuestion.setBackground(Color.WHITE);
            thisQuestion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            currentPlayerQuestions.add(thisQuestion);
        }
        for (int j = 0; j < gameRules.getNumberOfQuestions(); j++) {
            JPanel thisQuestion = new JPanel();
            thisQuestion.setPreferredSize(new Dimension(35, 35));
            thisQuestion.setBackground(Color.WHITE);
            thisQuestion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            otherPlayerQuestions.add(thisQuestion);
        }


        if (gameRules.getNumberOfRounds() >= 1) {
            List<JPanel> firstRound = copyList(currentPlayerQuestions);
            for (JPanel panel : firstRound) {
                firstRoundLongPanel.add(panel);
            }
            firstRoundLongPanel.add(spaceFillerList.get(6));
            firstRoundLongPanel.add(round1Label);
            firstRoundLongPanel.add(spaceFillerList.get(7));
            firstRound = copyList(otherPlayerQuestions);
            for (JPanel panel : firstRound) {
                firstRoundLongPanel.add(panel);
            }
        }

        if (gameRules.getNumberOfRounds() >= 2) {
            List<JPanel> secondRound = copyList(currentPlayerQuestions);
            for (JPanel panel : secondRound) {
                secondRoundLongPanel.add(panel);
            }
            secondRoundLongPanel.add(spaceFillerList.get(8));
            secondRoundLongPanel.add(round2Label);
            secondRoundLongPanel.add(spaceFillerList.get(9));
            secondRound = copyList(otherPlayerQuestions);
            for (JPanel panel : secondRound) {
                secondRoundLongPanel.add(panel);
            }
        }

        if (gameRules.getNumberOfRounds() >= 3) {
            List<JPanel> thirdRound = copyList(currentPlayerQuestions);

            for (JPanel panel : thirdRound) {
                thirdRoundLongPanel.add(panel);
            }
            thirdRoundLongPanel.add(spaceFillerList.get(10));
            thirdRoundLongPanel.add(round3Label);
            thirdRoundLongPanel.add(spaceFillerList.get(11));
            thirdRound = copyList(otherPlayerQuestions);
            for (JPanel panel : thirdRound) {
                thirdRoundLongPanel.add(panel);
            }
        }
        if (gameRules.getNumberOfRounds() >= 4) {
            List<JPanel> fourthRound = copyList(currentPlayerQuestions);
            for (JPanel panel : fourthRound) {
                fourthRoundLongPanel.add(panel);
            }
            fourthRoundLongPanel.add(spaceFillerList.get(12));
            fourthRoundLongPanel.add(round4Label);
            fourthRoundLongPanel.add(spaceFillerList.get(13));
            fourthRound = copyList(otherPlayerQuestions);
            for (JPanel panel : fourthRound) {
                fourthRoundLongPanel.add(panel);
            }
        }
        if (gameRules.getNumberOfRounds() >= 5) {
            List<JPanel> fifthRound = copyList(currentPlayerQuestions);
            for (JPanel panel : fifthRound) {
                fifthRoundLongPanel.add(panel);
            }
            fifthRoundLongPanel.add(spaceFillerList.get(14));
            fifthRoundLongPanel.add(round5Label);
            fifthRoundLongPanel.add(spaceFillerList.get(15));
            fifthRound = copyList(otherPlayerQuestions);
            for (JPanel panel : fifthRound) {
                fifthRoundLongPanel.add(panel);
            }
        }

    }

    private List<JPanel> copyList(List<JPanel> sourceList) {
        List<JPanel> copy = new ArrayList<>();
        for (JPanel panel : sourceList) {
            JPanel panelCopy = new JPanel();
            panelCopy.setPreferredSize(panel.getPreferredSize());
            panelCopy.setBackground(panel.getBackground());
            copy.add(panelCopy);
        }
        return copy;
    }

    public void showResult(List<Boolean> currentPlayerAnswers, List<Boolean> otherPlayerAnswers, int round) {
        switch (round) {
            case 1:
                for (int i = 0; i < currentPlayerAnswers.size(); i++) {
                    if (currentPlayerAnswers.get(i)) {
                        firstRoundLongPanel.getComponent(i).setBackground(correctAnswerColor);
                    } else {
                        firstRoundLongPanel.getComponent(i).setBackground(incorrectAnswerColor);
                    }
                    if (otherPlayerAnswers.get(i)) {
                        firstRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(correctAnswerColor);
                    } else {
                        firstRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(incorrectAnswerColor);
                    }

                }
                break;
            case 2:
                for (int i = 0; i < currentPlayerAnswers.size(); i++) {
                    if (currentPlayerAnswers.get(i)) {
                        secondRoundLongPanel.getComponent(i).setBackground(correctAnswerColor);
                    } else {
                        secondRoundLongPanel.getComponent(i).setBackground(incorrectAnswerColor);
                    }
                    if (otherPlayerAnswers.get(i)) {
                        secondRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(correctAnswerColor);
                    } else {
                        secondRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(incorrectAnswerColor);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < currentPlayerAnswers.size(); i++) {
                    if (currentPlayerAnswers.get(i)) {
                        thirdRoundLongPanel.getComponent(i).setBackground(correctAnswerColor);
                    } else {
                        thirdRoundLongPanel.getComponent(i).setBackground(incorrectAnswerColor);
                    }
                    if (otherPlayerAnswers.get(i)) {
                        thirdRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(correctAnswerColor);
                    } else {
                        thirdRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(incorrectAnswerColor);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < currentPlayerAnswers.size(); i++) {
                    if (currentPlayerAnswers.get(i)) {
                        fourthRoundLongPanel.getComponent(i).setBackground(correctAnswerColor);
                    } else {
                        fourthRoundLongPanel.getComponent(i).setBackground(incorrectAnswerColor);
                    }
                    if (otherPlayerAnswers.get(i)) {
                        fourthRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(correctAnswerColor);
                    } else {
                        fourthRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(incorrectAnswerColor);
                    }
                }
                break;
            case 5:
                for (int i = 0; i < currentPlayerAnswers.size(); i++) {
                    if (currentPlayerAnswers.get(i)) {
                        fifthRoundLongPanel.getComponent(i).setBackground(correctAnswerColor);
                    } else {
                        fifthRoundLongPanel.getComponent(i).setBackground(incorrectAnswerColor);
                    }
                    if (otherPlayerAnswers.get(i)) {
                        fifthRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(correctAnswerColor);
                    } else {
                        fifthRoundLongPanel.getComponent(currentPlayerAnswers.size() + 3 + i).setBackground(incorrectAnswerColor);
                    }
                }
                break;
        }
    }

    public void resetResult(int round) {
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < gameRules.getNumberOfQuestions(); j++) {
                roundLongPanelArray[i].getComponent(j).setBackground(lighterGray);
                roundLongPanelArray[i].getComponent(gameRules.getNumberOfQuestions() + j + 3).setBackground(lighterGray);
            }
        }
    }

    public void resetUI(int round) {
        currentPlayerQuestions = new ArrayList<>();
        otherPlayerQuestions = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            roundLongPanelArray[i].removeAll();
        }
    }
}