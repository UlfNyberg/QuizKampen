package GUI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:49
 * Project: QuizKampen
 * Copyright: MIT
 */
public class GameBoardGUI extends JPanel {

    JPanel backgroundPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel answerAlternativesPanel = new JPanel();
    JPanel categoryPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel usernamePanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel pointsPanel = new JPanel();
    JPanel bottomButtonPanel = new JPanel();
    JPanel spacePanel = new JPanel();
    JPanel spacePanel2 = new JPanel();
    JPanel spacePanel3 = new JPanel();

    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("Monospace", Font.BOLD, 30);
    public Font font3 = new Font("SansSerif", Font.BOLD, 14);

    public int seconds = 1000;
    public Timer timer;


    public JButton alternative1 = new JButton("Alternativ 1");
    public JButton alternative2 = new JButton("Alternativ 2");
    public JButton alternative3 = new JButton("Alternativ 3");
    public JButton alternative4 = new JButton("Alternativ 4");
    public JButton continueButton = new JButton("");

    JLabel quizGameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);

    public JLabel timerLabel = new JLabel();

    public JLabel user1Label = new JLabel("Användare1");
    public JLabel user2Label = new JLabel("Användare2");
    JLabel spaceLabel = new JLabel("vs.");
    JLabel betweenLabel = new JLabel("-");

    JLabel pointsForUserLabel1 = new JLabel("Poäng: ");
    JLabel pointsForUserLabel2 = new JLabel("Poäng: ");
    JLabel categoryHeaderLabel = new JLabel("Kategori:");
    public JLabel categoryLabel = new JLabel("TV-spel");

    public JTextPane questionTextArea = new JTextPane();
    StyledDocument doc = questionTextArea.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();

    public JLabel currentPointsPlayer1Label = new JLabel("0");
    public JLabel currentPointsPlayer2Label = new JLabel("0");

    public GameBoardGUI(ActionListener al) {
        this.setLayout(new BorderLayout());
        categoryHeaderLabel.setFont(font1);
        user1Label.setFont(font1);
        user2Label.setFont(font1);
        quizGameLabel.setFont(font2);
        pointsForUserLabel1.setFont(font3);
        pointsForUserLabel2.setFont(font3);
        questionTextArea.setFont(font1);
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0,doc.getLength(), center, false);
        backgroundPanel.setLayout(new BorderLayout());
        this.add(backgroundPanel);
        backgroundPanel.add(northPanel, BorderLayout.NORTH, SwingConstants.CENTER);
        northPanel.setLayout(new BorderLayout());
        northPanel.add(titlePanel, BorderLayout.NORTH, SwingConstants.CENTER);
        northPanel.add(usernamePanel, BorderLayout.CENTER, SwingConstants.CENTER);
        northPanel.add(pointsPanel, BorderLayout.SOUTH, SwingConstants.CENTER);
        titlePanel.add(quizGameLabel);
        usernamePanel.add(user1Label);
        usernamePanel.add(spaceLabel);
        usernamePanel.add(user2Label);
        pointsPanel.add((pointsForUserLabel1));
        pointsPanel.add(currentPointsPlayer1Label);
        pointsPanel.add(spacePanel);
        pointsPanel.add(betweenLabel);
        pointsPanel.add(spacePanel2);
        pointsPanel.add(pointsForUserLabel2);
        pointsPanel.add(currentPointsPlayer2Label);

        alternative1.setOpaque(true);
        alternative2.setOpaque(true);
        alternative3.setOpaque(true);
        alternative4.setOpaque(true);

        timer = new Timer(1000, al);
        timerLabel.setFont(font3);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(categoryPanel, BorderLayout.NORTH, SwingConstants.CENTER);
        categoryPanel.add(categoryHeaderLabel);
        categoryPanel.add(categoryLabel);
        centerPanel.add(questionPanel, BorderLayout.CENTER, SwingConstants.CENTER);
        questionPanel.setLayout(new BorderLayout());
        questionPanel.add(questionTextArea, BorderLayout.CENTER);

        backgroundPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout());
        southPanel.add(answerAlternativesPanel, BorderLayout.CENTER);
        answerAlternativesPanel.setLayout(new GridLayout(2, 2));
        answerAlternativesPanel.add(alternative1);
        answerAlternativesPanel.add(alternative2);
        answerAlternativesPanel.add(alternative3);
        answerAlternativesPanel.add(alternative4);
        southPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
        bottomButtonPanel.setLayout(new FlowLayout());
        bottomButtonPanel.add(timerLabel);
        continueButton.setPreferredSize(new Dimension(360, 40));
        alternative1.setPreferredSize(new Dimension(180, 100));
        alternative3.setPreferredSize(new Dimension(180, 100));
        alternative2.setPreferredSize(new Dimension(180, 100));
        alternative4.setPreferredSize(new Dimension(180, 100));
        continueButton.addActionListener(al);
        alternative1.addActionListener(al);
        alternative2.addActionListener(al);
        alternative3.addActionListener(al);
        alternative4.addActionListener(al);
        questionPanel.setPreferredSize(new Dimension(320, 100));
        categoryPanel.setSize(1000, 1000);

        this.setSize(400, 600);
        backgroundPanel.setBackground(Color.PINK);
        centerPanel.setBackground(Color.PINK);
        southPanel.setBackground(Color.PINK);
        answerAlternativesPanel.setBackground(Color.PINK);
        categoryPanel.setBackground(Color.WHITE);
        categoryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        northPanel.setBackground(Color.PINK);
        bottomButtonPanel.setBackground(Color.PINK);
        titlePanel.setBackground(Color.PINK);
        pointsPanel.setBackground(Color.PINK);
        currentPointsPlayer1Label.setBackground(Color.WHITE);
        currentPointsPlayer2Label.setBackground(Color.WHITE);
        usernamePanel.setBackground(Color.PINK);
        spacePanel.setBackground(Color.PINK);
        spacePanel2.setBackground(Color.PINK);
        spacePanel3.setBackground(Color.PINK);
        questionPanel.setBackground(Color.WHITE);
        alternative1.setBackground(Color.WHITE);
        alternative2.setBackground(Color.WHITE);
        alternative3.setBackground(Color.WHITE);
        alternative4.setBackground(Color.WHITE);
        continueButton.setBackground(Color.WHITE);
        questionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        questionTextArea.setEditable(false);
        setVisible(true);

    }
}

