package GUI;

import Util.GameRules;

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
    JPanel category1Panel = new JPanel();
    JPanel category2Panel = new JPanel();
    JPanel category3Panel = new JPanel();
    JPanel category4Panel = new JPanel();
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

    public JButton category1Button = new JButton("Science");
    public JButton category2Button = new JButton("Djur & Natur");
    public JButton category3Button = new JButton("Djur & Natur");
    public JButton category4Button = new JButton("Djur & Natur");

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
        timeToChooseLabel.setFont(font1);
        category1Button.setFont(font1);
        category2Button.setFont(font1);
        category3Button.setFont(font1);
        category4Button.setFont(font1);

        gameNameLabel.setFont(font2);

        firstPanel.setBackground(Color.PINK);

        this.add(firstPanel);
        firstPanel.add(gameNamePanel);
        firstPanel.add(timeToChoosePanel);
        FlowLayout layout = (FlowLayout) firstPanel.getLayout();
        layout.setVgap(0);

        gameNamePanel.setLayout(new GridLayout(1, 1));
        timeToChoosePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 32));
        category1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        category2Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        category3Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        category4Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 12));
        bottomOfScreenPanel.setLayout(new FlowLayout());

        gameNamePanel.add(gameNameLabel);

        timeToChoosePanel.add(timeToChooseLabel);
        category1Panel.add(category1Button);
        category2Panel.add(category2Button);
        category3Panel.add(category3Button);
        category4Panel.add(category4Button);

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

        category1Panel.setBackground(Color.WHITE);
        category1Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        category2Panel.setBackground(Color.WHITE);
        category2Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        category3Panel.setBackground(Color.WHITE);
        category3Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        category4Panel.setBackground(Color.WHITE);
        category4Panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        bottomOfScreenPanel.setBackground(Color.PINK);
        bottomOfScreenPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        category1Button.setPreferredSize(new Dimension(350, 60));
        category2Button.setPreferredSize(new Dimension(350, 60));
        category3Button.setPreferredSize(new Dimension(350, 60));
        category4Button.setPreferredSize(new Dimension(350, 60));
        category1Button.setBackground(Color.WHITE);
        category2Button.setBackground(Color.WHITE);
        category3Button.setBackground(Color.WHITE);
        category4Button.setBackground(Color.WHITE);
        category1Button.addActionListener(al);
        category2Button.addActionListener(al);
        category3Button.addActionListener(al);
        category4Button.addActionListener(al);

        currentlyPlayingPanel.setPreferredSize(new Dimension(120, 35));

        setVisible(true);

    }

    public void setupUI(GameRules gameRules) {
        firstPanel.add(category1Panel);
        firstPanel.add(category2Panel);
        if (gameRules.getNumberOfCategories() >= 3) {
            firstPanel.add(category3Panel);
        }
        if (gameRules.getNumberOfCategories() == 4) {
            firstPanel.add(category4Panel);
        }
        //firstPanel.add(bottomOfScreenPanel);
    }

}
