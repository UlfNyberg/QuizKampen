import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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

    List<JPanel> playerOneQuestions = new ArrayList<>();
    JPanel player1Round1Question1Panel = new JPanel();
    JPanel player1Round1Question2Panel = new JPanel();
    JPanel player1Round1Question3Panel = new JPanel();

    JPanel player1Round2Question1Panel = new JPanel();
    JPanel player1Round2Question2Panel = new JPanel();
    JPanel player1Round2Question3Panel = new JPanel();

    JPanel player1Round3Question1Panel = new JPanel();
    JPanel player1Round3Question2Panel = new JPanel();
    JPanel player1Round3Question3Panel = new JPanel();

    JPanel player1Round4Question1Panel = new JPanel();
    JPanel player1Round4Question2Panel = new JPanel();
    JPanel player1Round4Question3Panel = new JPanel();

    JPanel categoryAndRound1Panel = new JPanel();
    JPanel categoryAndRound2Panel = new JPanel();
    JPanel categoryAndRound3Panel = new JPanel();
    JPanel categoryAndRound4Panel = new JPanel();

    List<JPanel> playerTwoQuestions = new ArrayList<>();
    JPanel player2Round1Question1Panel = new JPanel();
    JPanel player2Round1Question2Panel = new JPanel();
    JPanel player2Round1Question3Panel = new JPanel();

    JPanel player2Round2Question1Panel = new JPanel();
    JPanel player2Round2Question2Panel = new JPanel();
    JPanel player2Round2Question3Panel = new JPanel();

    JPanel player2Round3Question1Panel = new JPanel();
    JPanel player2Round3Question2Panel = new JPanel();
    JPanel player2Round3Question3Panel = new JPanel();

    JPanel player2Round4Question1Panel = new JPanel();
    JPanel player2Round4Question2Panel = new JPanel();
    JPanel player2Round4Question3Panel = new JPanel();

    JPanel currentlyPlayingPanel = new JPanel();

    //TODO: ändra alla spacefiller till spaceFiller listan
    List<JPanel> spaceFillerList = new ArrayList<>();
    JPanel spacefiller1Panel = new JPanel();
    JPanel spacefiller2Panel = new JPanel();
    JPanel spacefiller3Panel = new JPanel();
    JPanel spacefiller4Panel = new JPanel();
    JPanel spacefiller5Panel = new JPanel();
    JPanel spacefiller6Panel = new JPanel();
    JPanel spacefiller7Panel = new JPanel();
    JPanel spacefiller8Panel = new JPanel();
    JPanel spacefiller9Panel = new JPanel();
    JPanel spacefiller10Panel = new JPanel();
    JPanel spacefiller11Panel = new JPanel();
    JPanel spacefiller12Panel = new JPanel();
    JPanel spacefiller13Panel = new JPanel();
    JPanel spacefiller14Panel = new JPanel();
    JPanel spacefiller15Panel = new JPanel();
    JPanel spacefiller16Panel = new JPanel();

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
    JLabel player1NameLabel = new JLabel("Spelare1");
    JLabel player2NameLabel = new JLabel("Spelare2");
    JLabel currentPointsPlayer1label = new JLabel("PoängSpelare1");
    JLabel currentPointsPlayer2label = new JLabel("PoängSpelare2");
    JLabel versusLabel = new JLabel("vs.");
    JLabel betweenLabel = new JLabel("-");
    JLabel questionMark1Label = new JLabel("?");
    JLabel questionMark2Label = new JLabel("?");
    JLabel questionMark3Label = new JLabel("?");

    Color lighterGray = new Color(238, 235, 235);
    Color softerGreen = new Color(125, 255, 0);
    Color softerRed = new Color(255, 45, 33);

    CurrentResultGUI() {
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
        playerNamePanel.add(spacefiller1Panel);
        playerNamePanel.add(player1NameLabel);
        playerNamePanel.add(spacefiller2Panel);
        spacefiller2Panel.add(versusLabel);
        playerNamePanel.add(player2NameLabel);
        playerNamePanel.add(spacefiller3Panel);
        playerScorePanel.add(spacefiller4Panel);
        playerScorePanel.add(currentPointsPlayer1label);
        playerScorePanel.add(spacefiller5Panel);
        spacefiller5Panel.add(betweenLabel);
        playerScorePanel.add(currentPointsPlayer2label);
        playerScorePanel.add(spacefiller6Panel);

        for (int j = 0; j < GameRules.numberOfQuestions; j++) {
            JPanel thisQuestion = new JPanel();
            thisQuestion.setPreferredSize(new Dimension(35, 35));
            thisQuestion.setBackground(softerRed);
            playerOneQuestions.add(thisQuestion);
        }
        for (int j = 0; j < GameRules.numberOfQuestions; j++) {
            JPanel thisQuestion = new JPanel();
            thisQuestion.setPreferredSize(new Dimension(35, 35));
            thisQuestion.setBackground(Color.GREEN);
            playerTwoQuestions.add(thisQuestion);
        }


        if (GameRules.numberOfRounds >= 1) {
            List<JPanel> firstRound = copyList(playerOneQuestions);
            for (JPanel panel : firstRound) {
                firstRoundLongPanel.add(panel);
            }
            firstRoundLongPanel.add(spacefiller7Panel);
            firstRoundLongPanel.add(round1Label);
            firstRoundLongPanel.add(spacefiller8Panel);
            firstRound = copyList(playerTwoQuestions);
            for (JPanel panel : firstRound) {
                firstRoundLongPanel.add(panel);
            }
        }

        if (GameRules.numberOfRounds >= 2) {
            List<JPanel> secondRound = copyList(playerOneQuestions);
            for (JPanel panel : secondRound) {
                secondRoundLongPanel.add(panel);
            }
            secondRoundLongPanel.add(spacefiller9Panel);
            secondRoundLongPanel.add(round2Label);
            secondRoundLongPanel.add(spacefiller10Panel);
            secondRound = copyList(playerTwoQuestions);
            for (JPanel panel : secondRound) {
                secondRoundLongPanel.add(panel);
            }
        }

        if (GameRules.numberOfRounds >= 3) {
            List<JPanel> thirdRound = copyList(playerOneQuestions);
            for (JPanel panel : thirdRound) {
                thirdRoundLongPanel.add(panel);
            }
            thirdRoundLongPanel.add(spacefiller11Panel);
            thirdRoundLongPanel.add(round3Label);
            thirdRoundLongPanel.add(spacefiller12Panel);
            thirdRound = copyList(playerTwoQuestions);
            for (JPanel panel : thirdRound) {
                thirdRoundLongPanel.add(panel);
            }
        }
        if (GameRules.numberOfRounds >= 4) {
            List<JPanel> fourthRound = copyList(playerOneQuestions);
            for (JPanel panel : fourthRound) {
                fourthRoundLongPanel.add(panel);
            }
            fourthRoundLongPanel.add(spacefiller13Panel);
            fourthRoundLongPanel.add(round4Label);
            fourthRoundLongPanel.add(spacefiller14Panel);
            fourthRound = copyList(playerTwoQuestions);
            for (JPanel panel : fourthRound) {
                fourthRoundLongPanel.add(panel);
            }
        }
        if (GameRules.numberOfRounds >= 5) {
            List<JPanel> fifthRound = copyList(playerOneQuestions);
            for (JPanel panel : playerOneQuestions) {
                fifthRoundLongPanel.add(panel);
            }
            fifthRoundLongPanel.add(spacefiller15Panel);
            fifthRoundLongPanel.add(round5Label);
            fifthRoundLongPanel.add(spacefiller16Panel);
            fifthRound = copyList(playerTwoQuestions);
            for (JPanel panel : fifthRound) {
                fifthRoundLongPanel.add(panel);
            }
        }
        setSize(400, 600);
        panel3.setBackground(Color.PINK);
        panel4.setBackground(Color.PINK);
        spacefiller1Panel.setBackground(Color.PINK);
        spacefiller2Panel.setBackground(Color.PINK);
        spacefiller3Panel.setBackground(Color.PINK);
        spacefiller4Panel.setBackground(Color.PINK);
        spacefiller5Panel.setBackground(Color.PINK);
        spacefiller6Panel.setBackground(Color.PINK);
        gameNamePanel.setBackground(Color.PINK);
        currentlyPlayingPanel.setBackground(Color.PINK);
        playerNamePanel.setBackground(Color.PINK);
        playerScorePanel.setBackground(Color.PINK);
        playerInfoLongPanel.setBackground(Color.PINK);
        playerInfoSpaceFillerLongPanel.setBackground((Color.PINK));
        firstRoundLongPanel.setBackground(Color.WHITE);
        firstRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        secondRoundLongPanel.setBackground(Color.WHITE);
        secondRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        thirdRoundLongPanel.setBackground(Color.WHITE);
        thirdRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        fourthRoundLongPanel.setBackground(Color.WHITE);
        fourthRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        fifthRoundLongPanel.setBackground(Color.WHITE);
        fifthRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        currentlyPlayingPanel.setPreferredSize(new Dimension(120, 35));
        player1Round1Question1Panel.setBackground(softerRed);
        player1Round1Question1Panel.setPreferredSize(new Dimension(35, 35));
        player1Round1Question2Panel.setBackground(softerGreen);
        player1Round1Question2Panel.setPreferredSize(new Dimension(35, 35));
        player1Round1Question3Panel.setBackground(softerGreen);
        player1Round1Question3Panel.setPreferredSize(new Dimension(35, 35));
        player2Round1Question1Panel.setBackground(softerGreen);
        player2Round1Question1Panel.setPreferredSize(new Dimension(35, 35));
        player2Round1Question2Panel.setBackground(softerRed);
        player2Round1Question2Panel.setPreferredSize(new Dimension(35, 35));
        player2Round1Question3Panel.setBackground(softerRed);
        player2Round1Question3Panel.setPreferredSize(new Dimension(35, 35));
        spacefiller7Panel.setBackground(Color.WHITE);
        spacefiller8Panel.setBackground(Color.WHITE);
        spacefiller9Panel.setBackground(Color.WHITE);
        spacefiller10Panel.setBackground(Color.WHITE);
        spacefiller11Panel.setBackground(Color.WHITE);
        spacefiller12Panel.setBackground(Color.WHITE);
        spacefiller13Panel.setBackground(Color.WHITE);
        spacefiller14Panel.setBackground(Color.WHITE);
        spacefiller15Panel.setBackground(Color.WHITE);
        spacefiller16Panel.setBackground(Color.WHITE);
        player1Round2Question1Panel.setBackground(Color.WHITE);
        player1Round2Question1Panel.setPreferredSize(new Dimension(35, 35));
        player1Round2Question2Panel.setBackground(Color.WHITE);
        player1Round2Question2Panel.setPreferredSize(new Dimension(35, 35));
        player1Round2Question3Panel.setBackground(Color.WHITE);
        player1Round2Question3Panel.setPreferredSize(new Dimension(35, 35));
        player2Round2Question1Panel.setBackground(lighterGray);
        player2Round2Question1Panel.setPreferredSize(new Dimension(35, 35));
        player2Round2Question2Panel.setBackground(lighterGray);
        player2Round2Question2Panel.setPreferredSize(new Dimension(35, 35));
        player2Round2Question3Panel.setBackground(lighterGray);
        player2Round2Question3Panel.setPreferredSize(new Dimension(35, 35));

        setVisible(true);
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

    public void showResult(List<List<Boolean>> currentPlayerAnswers, List<List<Boolean>> otherPlayerAnswers) {

    }
}

