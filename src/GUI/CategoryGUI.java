package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-17
 * Time: 10:21
 * Project: QuizKampen
 * Copyright: MIT
 */
public class CategoryGUI extends JPanel {

    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    JPanel firstPanel = new JPanel();
    JPanel gameNamePanel = new JPanel();
    JPanel timeToChoosePanel = new JPanel();
    JPanel playerInfoSpaceFillerLongPanel = new JPanel();
    JPanel playerScorePanel = new JPanel();
    JPanel playerNamePanel = new JPanel();
    JPanel chooseBetweenPanel = new JPanel();
    JPanel category1Panel = new JPanel();
    JPanel category2Panel = new JPanel();
    JPanel bottomOfScreenPanel = new JPanel();


    JPanel currentlyPlayingPanel = new JPanel();

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


    JLabel timeToChooseLabel = new JLabel("DAGS ATT VÄLJA EN KATEGORI!");

    JLabel chooseCategoryLabel = new JLabel("VÄLJ MELLAN");

    public JButton category1Button = new JButton("Science");
    public JButton category2Button = new JButton("Djur & Natur");

    //////////////////////////////////

    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("Monospace", Font.BOLD, 30);
    Font font3 = new Font("SansSerif", Font.BOLD, 15);

    JLabel gameNameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);


    Color lighterGray = new Color(238, 235, 235);
    Color softerGreen = new Color(125, 255, 0);
    Color softerRed = new Color(255, 45, 33);


    public CategoryGUI(ActionListener al) {
        this.setLayout(new BorderLayout());
        chooseCategoryLabel.setFont(font2);
        timeToChooseLabel.setFont(font1);
        category1Button.setFont(font1);
        category2Button.setFont(font1);

        gameNameLabel.setFont(font2);

        firstPanel.setLayout(new GridLayout(6, 1));

        this.add(firstPanel);
        firstPanel.add(gameNamePanel);
        firstPanel.add(timeToChoosePanel);
        firstPanel.add(chooseBetweenPanel);
        firstPanel.add(category1Panel);
        firstPanel.add(category2Panel);
        firstPanel.add(bottomOfScreenPanel);

        gameNamePanel.setLayout(new GridLayout(1, 1));
        timeToChoosePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 32));
        chooseBetweenPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 22));
        category1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        category2Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        bottomOfScreenPanel.setLayout(new FlowLayout());

        gameNamePanel.add(gameNameLabel);


        timeToChoosePanel.add(timeToChooseLabel);
        chooseBetweenPanel.add(chooseCategoryLabel);
        category1Panel.add(category1Button);
        category2Panel.add(category2Button);


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
        timeToChoosePanel.setBackground(Color.PINK);
        playerInfoSpaceFillerLongPanel.setBackground((Color.PINK));

        chooseBetweenPanel.setBackground(Color.WHITE);
        chooseBetweenPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        category1Panel.setBackground(Color.WHITE);
        category1Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        category2Panel.setBackground(Color.WHITE);
        category2Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        bottomOfScreenPanel.setBackground(Color.PINK);
        bottomOfScreenPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        category1Button.setPreferredSize(new Dimension(350, 60));
        category2Button.setPreferredSize(new Dimension(350, 60));
        category1Button.setBackground(Color.WHITE);
        category2Button.setBackground(Color.WHITE);
        category1Button.addActionListener(al);
        category2Button.addActionListener(al);

        currentlyPlayingPanel.setPreferredSize(new Dimension(120, 35));

        setVisible(true);

    }

}
