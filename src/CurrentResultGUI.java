import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:48
 * Project: QuizKampen
 * Copyright: MIT
 */
public class CurrentResultGUI extends JFrame implements ActionListener {

    //ImageIcon image = new ImageIcon("  ");
    JFrame frame = new JFrame("Quiz Game");

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
    JPanel bottomOfScreenPanel = new JPanel();
    //JPanel firstPanel = new JPanel();
    //JPanel firstPanel = new JPanel();
    //JPanel firstPanel = new JPanel();

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


    JPanel spacefiller1Panel = new JPanel();
    JPanel spacefiller2Panel = new JPanel();
    JPanel spacefiller3Panel = new JPanel();
    JPanel spacefiller4Panel = new JPanel();
    JPanel spacefiller5Panel = new JPanel();
    JPanel spacefiller6Panel = new JPanel();
    JPanel spacefiller7Panel = new JPanel();
    JPanel spacefiller8Panel = new JPanel();






    JButton spelare1button1 = new JButton("neutral");
    JButton spelare1button2 = new JButton("neutral");
    JButton spelare1button3 = new JButton("neutral");

    JButton spelare1button4 = new JButton("neutral");
    JButton spelare1button5 = new JButton("neutral");
    JButton spelare1button6 = new JButton("neutral");

    JButton spelare1button7 = new JButton("neutral");
    JButton spelare1button8 = new JButton("neutral");
    JButton spelare1button9 = new JButton("neutral");

    JButton spelare1button10 = new JButton("neutral");
    JButton spelare1button11 = new JButton("neutral");
    JButton spelare1button12 = new JButton("neutral");

    JButton continue2Button = new JButton("Fortsätt");

    JLabel round1Label = new JLabel("Runda 1");
    JLabel round2Label = new JLabel("Runda 2");
    JLabel round3Label = new JLabel("Runda 3");
    JLabel round4Label = new JLabel("Runda 4");

    ///////////////////////////////

    JButton spelare2button1 = new JButton("neutral");
    JButton spelare2button2 = new JButton("neutral");
    JButton spelare2button3 = new JButton("neutral");

    JButton spelare2button4 = new JButton("neutral");
    JButton spelare2button5 = new JButton("neutral");
    JButton spelare2button6 = new JButton("neutral");

    JButton spelare2button7 = new JButton("neutral");
    JButton spelare2button8 = new JButton("neutral");
    JButton spelare2button9 = new JButton("neutral");

    JButton spelare2button10 = new JButton("neutral");
    JButton spelare2button11 = new JButton("neutral");
    JButton spelare2button12 = new JButton("neutral");

    //////////////////////////////////

    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("Monospace", Font.BOLD, 30);
    Font font3 = new Font("SansSerif", Font.BOLD, 15);

    JLabel gameNameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);
    JLabel player1NameLabel = new JLabel("Spelare1");
    JLabel player2NameLabel = new JLabel("Spelare2");
    JLabel currentPointsPlayer1label = new JLabel("PoängSpelare1");
    JLabel currentPointsPlayer2label = new JLabel("PoängSpelare2");
    JLabel versusLabel = new JLabel("vs.");
    JLabel betweenLabel = new JLabel("-");

    Color lighterGray = new Color(238,235,235);



    CurrentResultGUI(){
        gameNameLabel.setFont(font2);
        player1NameLabel.setFont(font1);
        player2NameLabel.setFont(font1);
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        //  **** panel3.setLayout(new BorderLayout());
        firstPanel.setLayout(new GridLayout(7,1));
        //  **** add(panel3);
        this.add(firstPanel);
        firstPanel.add(gameNamePanel);
        firstPanel.add(playerInfoLongPanel);
        firstPanel.add(firstRoundLongPanel);
        firstPanel.add(secondRoundLongPanel);
        firstPanel.add(thirdRoundLongPanel);
        firstPanel.add(fourthRoundLongPanel);
        firstPanel.add(bottomOfScreenPanel);
        gameNamePanel.setLayout(new GridLayout(1,1));
        playerInfoLongPanel.setLayout(new BorderLayout());
        playerInfoLongPanel.add(playerNamePanel, BorderLayout.NORTH, SwingConstants.CENTER);
        //playerNamePanel.setLayout(new GridLayout(1, 5));
        playerNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER,8,8));
        playerInfoLongPanel.add(playerScorePanel, BorderLayout.CENTER, SwingConstants.CENTER);
        //playerScorePanel.setLayout(new GridLayout(1,5));
        playerScorePanel.setLayout(new FlowLayout(FlowLayout.CENTER,8,8));
        playerInfoLongPanel.add(playerInfoSpaceFillerLongPanel, BorderLayout.SOUTH, SwingConstants.CENTER);
        //firstRoundLongPanel.setLayout(new GridLayout(1,5));
        firstRoundLongPanel.setLayout(new FlowLayout(FlowLayout.CENTER,8,22));

        secondRoundLongPanel.setLayout(new GridLayout(1,5));
        thirdRoundLongPanel.setLayout(new GridLayout(1,5));
        fourthRoundLongPanel.setLayout(new GridLayout(1,5));
        bottomOfScreenPanel.setLayout(new FlowLayout());
        bottomOfScreenPanel.add(continue2Button);
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


        firstRoundLongPanel.add(player1Round1Question1Panel);
        firstRoundLongPanel.add(player1Round1Question2Panel);
        firstRoundLongPanel.add(player1Round1Question3Panel);
        firstRoundLongPanel.add(spacefiller7Panel);
        firstRoundLongPanel.add(round1Label);
        firstRoundLongPanel.add(spacefiller8Panel);
        firstRoundLongPanel.add(player2Round1Question1Panel);
        firstRoundLongPanel.add(player2Round1Question2Panel);
        firstRoundLongPanel.add(player2Round1Question3Panel);



        /*
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        panel3.add(label1, BorderLayout.NORTH);
        //panel3.add(button5, BorderLayout.SOUTH);
        //panel3.add(button1, BorderLayout.WEST);
        //panel3.add(button2, BorderLayout.EAST);
        panel3.add(panel4, BorderLayout.CENTER);
        panel4.setLayout(new GridLayout(4,7));
        panel4.add(spelare1button1);
        panel4.add(spelare1button2);
        panel4.add(spelare1button3);
        panel4.add(runda1Label);
        panel4.add(spelare2button1);
        panel4.add(spelare2button2);
        panel4.add(spelare2button3);

        panel4.add(spelare1button4);
        panel4.add(spelare1button5);
        panel4.add(spelare1button6);
        panel4.add(runda2Label);
        panel4.add(spelare2button4);
        panel4.add(spelare2button5);
        panel4.add(spelare2button6);

        panel4.add(spelare1button7);
        panel4.add(spelare1button8);
        panel4.add(spelare1button9);
        panel4.add(runda3Label);
        panel4.add(spelare2button7);
        panel4.add(spelare2button8);
        panel4.add(spelare2button9);

        panel4.add(spelare1button10);
        panel4.add(spelare1button11);
        panel4.add(spelare1button12);
        panel4.add(runda4Label);
        panel4.add(spelare2button10);
        panel4.add(spelare2button11);
        panel4.add(spelare2button12);

        spelare1button1.setPreferredSize(new Dimension(40,40));
        spelare1button2.setPreferredSize(new Dimension(40,40));
        spelare1button3.setPreferredSize(new Dimension(40,40));
        spelare1button4.setPreferredSize(new Dimension(40,40));
        spelare1button5.setPreferredSize(new Dimension(40,40));
        spelare1button6.setPreferredSize(new Dimension(40,40));
        spelare1button7.setPreferredSize(new Dimension(40,40));

         */



        continue2Button.addActionListener(this);
        round1Label.setFont(font3);
        round2Label.setFont(font3);
        round3Label.setFont(font3);
        round4Label.setFont(font3);
        setTitle("Quiz Game");
        setSize(400,600);
        panel3.setBackground( Color.PINK );
        panel4.setBackground( Color.PINK );
        spacefiller1Panel.setBackground( Color.PINK );
        spacefiller2Panel.setBackground( Color.PINK );
        spacefiller3Panel.setBackground( Color.PINK );
        spacefiller4Panel.setBackground( Color.PINK );
        spacefiller5Panel.setBackground( Color.PINK );
        spacefiller6Panel.setBackground( Color.PINK );
        gameNamePanel.setBackground( Color.PINK );
        playerNamePanel.setBackground( Color.PINK);
        playerScorePanel.setBackground(Color.PINK);
        playerInfoLongPanel.setBackground( Color.PINK );
        playerInfoSpaceFillerLongPanel.setBackground(( Color.PINK));;
        firstRoundLongPanel.setBackground(lighterGray);
        firstRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        secondRoundLongPanel.setBackground(Color.WHITE);
        secondRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        thirdRoundLongPanel.setBackground(Color.WHITE);
        thirdRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        fourthRoundLongPanel.setBackground(Color.WHITE);
        fourthRoundLongPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        bottomOfScreenPanel.setBackground(Color.PINK);
        bottomOfScreenPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        continue2Button.setPreferredSize(new Dimension(350,60));
        //bottomOfScreenPanel.setPreferredSize(new Dimension(400,80)); //resize funkar ej
        player1Round1Question1Panel.setBackground(Color.RED);
        player1Round1Question1Panel.setPreferredSize(new Dimension(35,35));
        player1Round1Question2Panel.setBackground(Color.GREEN);
        player1Round1Question2Panel.setPreferredSize(new Dimension(35,35));
        player1Round1Question3Panel.setBackground(Color.GREEN);
        player1Round1Question3Panel.setPreferredSize(new Dimension(35,35));
        player2Round1Question1Panel.setBackground(Color.GREEN);
        player2Round1Question1Panel.setPreferredSize(new Dimension(35,35));
        player2Round1Question2Panel.setBackground(Color.RED);
        player2Round1Question2Panel.setPreferredSize(new Dimension(35,35));
        player2Round1Question3Panel.setBackground(Color.RED);
        player2Round1Question3Panel.setPreferredSize(new Dimension(35,35));
        spacefiller7Panel.setBackground(lighterGray);
        spacefiller8Panel.setBackground(lighterGray);

        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (continue2Button.getText().equalsIgnoreCase("Fortsätt")) {
            continue2Button.setText("The Mario/Luigi Conspiracy");

        }
    }



    public static void main(String[] args) {

        CurrentResultGUI currentResultGUI = new CurrentResultGUI();
    }
}

