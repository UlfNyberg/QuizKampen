import javax.swing.*;
import java.awt.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:49
 * Project: QuizKampen
 * Copyright: MIT
 */
public class GameBoardGUI extends JFrame {

    //ImageIcon image = new ImageIcon("  ");
    //Dimension d = new Dimension(200,200);

    JFrame frame = new JFrame("Quiz Game");

    JPanel grundPanel = new JPanel();
    JPanel nordPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel sydPanel = new JPanel();
    JPanel svarsAlternativPanel = new JPanel();
    JPanel kategoriPanel = new JPanel();
    JPanel titelPanel = new JPanel();
    JPanel namnPåAnvändarePanel = new JPanel();
    JPanel fråganPanel = new JPanel();
    JPanel poängPanel = new JPanel();
    JPanel bottenKnappPanel = new JPanel();
    JPanel mellanrumsPanel = new JPanel();
    JPanel mellanrumsPanel2 = new JPanel();
    JPanel mellanrumsPanel3 = new JPanel();

    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("Monospace", Font.BOLD, 30);
    Font font3 = new Font("SansSerif", Font.BOLD, 14);


    JButton valAvSvar1 = new JButton("Alternativ 1");
    JButton valAvSvar2  = new JButton("Alternativ 2");
    JButton valAvSvar3  = new JButton("Alternativ 3");
    JButton valAvSvar4  = new JButton("Alternativ 4");
    JButton fortsättButton = new JButton("Fortsätt");

    //valAvSvar1.setPreferredSize(d);  //vidareundersök knappstorlek


    JLabel quizGameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);

    JLabel användare1Label = new JLabel("Användare1");
    JLabel användare2Label = new JLabel("Användare2");
    JLabel mellanrum = new JLabel("- - - - - -");

    JLabel poängSpelare1 = new JLabel("Poäng: ");
    JLabel poängSpelare2 = new JLabel("Poäng: ");

    JLabel kategoriLabel = new JLabel("Kategori:");
    JLabel katerogi1Label = new JLabel("TV-spel");
    JLabel kategori2Label = new JLabel("Film");
    JLabel kategori3Label = new JLabel("Djur & Natur");
    JLabel kategori4Label = new JLabel("Science");

    JLabel frågaStatiskLabel =  new JLabel("Fråga:");
    JLabel fråganTestLabel = new JLabel("Vilken relation har Mario och Luigi...egentligen?");

    JLabel SpelNamn = new JLabel("Quiz Game");

    //JTextField scoreInputAnvändare1 = new JTextField();
    //JTextField scoreInputAnvändare2 = new JTextField();
    JPanel scoreInputAnvändare1 = new JPanel();
    JPanel scoreInputAnvändare2 = new JPanel();



    GameBoardGUI(){
        kategoriLabel.setFont(font1);
        användare1Label.setFont(font1);
        användare2Label.setFont(font1);
        quizGameLabel.setFont(font2);
        fråganTestLabel.setFont(font3);
        poängSpelare1.setFont(font3);
        poängSpelare2.setFont(font3);
        frågaStatiskLabel.setFont(font1);
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        grundPanel.setLayout(new BorderLayout());
        this.add(grundPanel);
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        grundPanel.add(nordPanel, BorderLayout.NORTH, SwingConstants.CENTER);
        nordPanel.setLayout(new BorderLayout());
        nordPanel.add(titelPanel, BorderLayout.NORTH, SwingConstants.CENTER);
        nordPanel.add(namnPåAnvändarePanel, BorderLayout.CENTER, SwingConstants.CENTER);
        nordPanel.add(poängPanel, BorderLayout.SOUTH, SwingConstants.CENTER);
        titelPanel.add(quizGameLabel);
        namnPåAnvändarePanel.add(användare1Label); //SwingConstants.LEFT
        namnPåAnvändarePanel.add(mellanrum);
        namnPåAnvändarePanel.add(användare2Label);  //SwingConstants.RIGHT
        poängPanel.setLayout(new GridLayout(1,7));
        poängPanel.add(mellanrumsPanel);
        poängPanel.add((poängSpelare1));
        poängPanel.add(scoreInputAnvändare1);
        poängPanel.add(mellanrumsPanel2);
        poängPanel.add(poängSpelare2);
        poängPanel.add(scoreInputAnvändare2);
        poängPanel.add(mellanrumsPanel3);


        //panel3.add(button5, BorderLayout.SOUTH);
        //panel3.add(button1, BorderLayout.WEST);
        //panel3.add(button2, BorderLayout.EAST);
        grundPanel.add(centerPanel, BorderLayout.CENTER);
        //panel4.add(kategoriLabel);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(kategoriPanel, BorderLayout.NORTH, SwingConstants.CENTER);   //
        kategoriPanel.add(kategoriLabel);
        kategoriPanel.add(katerogi1Label);
        centerPanel.add(fråganPanel, BorderLayout.CENTER, SwingConstants.CENTER );
        fråganPanel.setLayout(new GridLayout(2,1));
        fråganPanel.add(frågaStatiskLabel, BorderLayout.NORTH);
        fråganPanel.add(fråganTestLabel, BorderLayout.CENTER);



        grundPanel.add(sydPanel, BorderLayout.SOUTH);
        sydPanel.setLayout(new BorderLayout());
        sydPanel.add(svarsAlternativPanel, BorderLayout.CENTER);
        svarsAlternativPanel.setLayout(new GridLayout(2,2));
        svarsAlternativPanel.add(valAvSvar1);
        svarsAlternativPanel.add(valAvSvar2);
        svarsAlternativPanel.add(valAvSvar3);
        svarsAlternativPanel.add(valAvSvar4);
        sydPanel.add(bottenKnappPanel, BorderLayout.SOUTH);
        bottenKnappPanel.setLayout(new FlowLayout());

        bottenKnappPanel.add(fortsättButton);
        fortsättButton.setPreferredSize(new Dimension(360,40));
        valAvSvar1.setPreferredSize(new Dimension(180,100));
        valAvSvar3.setPreferredSize(new Dimension(180,100));
        valAvSvar2.setPreferredSize(new Dimension(180,100));
        valAvSvar4.setPreferredSize(new Dimension(180,100));
        fråganPanel.setPreferredSize(new Dimension(320,100)); ////
        kategoriPanel.setSize(1000,1000);




        /*
        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);

         */

        setTitle("Quiz Game");
        this.setSize(400,600);
        //bottenKnappPanel.setPreferredSize(new Dimension(400, 200));

        grundPanel.setBackground( Color.PINK );
        centerPanel.setBackground( Color.PINK );
        sydPanel.setBackground( Color.PINK );
        svarsAlternativPanel.setBackground( Color.PINK );
        kategoriPanel.setBackground(Color.WHITE);
        kategoriPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        nordPanel.setBackground( Color.PINK );
        bottenKnappPanel.setBackground( Color.PINK );
        titelPanel.setBackground( Color.PINK );
        poängPanel.setBackground( Color.PINK);
        scoreInputAnvändare1.setBackground(Color.WHITE);
        scoreInputAnvändare2.setBackground(Color.WHITE);
        namnPåAnvändarePanel.setBackground( Color.PINK );
        mellanrumsPanel.setBackground( Color.PINK);
        mellanrumsPanel2.setBackground( Color.PINK);
        mellanrumsPanel3.setBackground( Color.PINK);
        fråganPanel.setBackground(Color.WHITE);
        fråganPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        GameBoardGUI gameBoardGUI = new GameBoardGUI();
    }
}

