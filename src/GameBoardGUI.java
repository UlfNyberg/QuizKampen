import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:49
 * Project: QuizKampen
 * Copyright: MIT
 */
public class GameBoardGUI extends JFrame implements ActionListener {

    //ImageIcon image = new ImageIcon("  ");
    //Dimension d = new Dimension(200,200);

    Boolean correctAnswer;

    JFrame frame = new JFrame("Quiz Game");

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
    Font font3 = new Font("SansSerif", Font.BOLD, 14);


    JButton alternative1 = new JButton("Alternativ 1");
    JButton alternative2 = new JButton("Alternativ 2");
    JButton alternative3 = new JButton("Alternativ 3");
    JButton alternative4 = new JButton("Alternativ 4");
    JButton continueButton = new JButton("Fortsätt");

    //valAvSvar1.setPreferredSize(d);  //vidareundersök knappstorlek


    JLabel quizGameLabel = new JLabel("QUIZ GAME", SwingConstants.CENTER);

    JLabel user1Label = new JLabel("Användare1");
    JLabel user2Label = new JLabel("Användare2");
    JLabel spaceLabel = new JLabel("- - - - - -");

    JLabel pointsForUserLabel1 = new JLabel("Poäng: ");
    JLabel pointsForUserLabel2 = new JLabel("Poäng: ");

    JLabel categoryHeaderLabel = new JLabel("Kategori:");
    JLabel category1Label = new JLabel("TV-spel");
    JLabel category2Label = new JLabel("Film");
    JLabel category3Label = new JLabel("Djur & Natur");
    JLabel category4Label = new JLabel("Science");

    JLabel questionStaticLabel =  new JLabel("Fråga:");
    JLabel questionTestLabel = new JLabel("Vilken relation har Mario och Luigi...egentligen?");
    JTextArea questionTextArea = new JTextArea(4,5);


    JLabel gameNameLabel = new JLabel("Quiz Game");

    //JTextField scoreInputAnvändare1 = new JTextField();
    //JTextField scoreInputAnvändare2 = new JTextField();
    JPanel scoreInputUser1 = new JPanel();
    JPanel scoreInputUser2 = new JPanel();



    GameBoardGUI(){
        categoryHeaderLabel.setFont(font1);
        user1Label.setFont(font1);
        user2Label.setFont(font1);
        quizGameLabel.setFont(font2);
        questionTestLabel.setFont(font3);
        pointsForUserLabel1.setFont(font3);
        pointsForUserLabel2.setFont(font3);
        questionStaticLabel.setFont(font1);
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        backgroundPanel.setLayout(new BorderLayout());
        this.add(backgroundPanel);
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        backgroundPanel.add(northPanel, BorderLayout.NORTH, SwingConstants.CENTER);
        northPanel.setLayout(new BorderLayout());
        northPanel.add(titlePanel, BorderLayout.NORTH, SwingConstants.CENTER);
        northPanel.add(usernamePanel, BorderLayout.CENTER, SwingConstants.CENTER);
        northPanel.add(pointsPanel, BorderLayout.SOUTH, SwingConstants.CENTER);
        titlePanel.add(quizGameLabel);
        usernamePanel.add(user1Label); //SwingConstants.LEFT
        usernamePanel.add(spaceLabel);
        usernamePanel.add(user2Label);  //SwingConstants.RIGHT
        pointsPanel.setLayout(new GridLayout(1,7));
        pointsPanel.add(spacePanel);
        pointsPanel.add((pointsForUserLabel1));
        pointsPanel.add(scoreInputUser1);
        pointsPanel.add(spacePanel2);
        pointsPanel.add(pointsForUserLabel2);
        pointsPanel.add(scoreInputUser2);
        pointsPanel.add(spacePanel3);


        //panel3.add(button5, BorderLayout.SOUTH);
        //panel3.add(button1, BorderLayout.WEST);
        //panel3.add(button2, BorderLayout.EAST);
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
        //panel4.add(kategoriLabel);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(categoryPanel, BorderLayout.NORTH, SwingConstants.CENTER);   //
        categoryPanel.add(categoryHeaderLabel);
        categoryPanel.add(category1Label);
        centerPanel.add(questionPanel, BorderLayout.CENTER, SwingConstants.CENTER );
        questionPanel.setLayout(new GridLayout(2,1));
        questionPanel.add(questionStaticLabel, BorderLayout.NORTH);
        //questionPanel.add(questionTestLabel, BorderLayout.CENTER);
        questionPanel.add(questionTextArea, BorderLayout.CENTER);



        backgroundPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout());
        southPanel.add(answerAlternativesPanel, BorderLayout.CENTER);
        answerAlternativesPanel.setLayout(new GridLayout(2,2));
        answerAlternativesPanel.add(alternative1);
        answerAlternativesPanel.add(alternative2);
        answerAlternativesPanel.add(alternative3);
        answerAlternativesPanel.add(alternative4);
        southPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
        bottomButtonPanel.setLayout(new FlowLayout());

        bottomButtonPanel.add(continueButton);
        continueButton.setPreferredSize(new Dimension(360,40));
        alternative1.setPreferredSize(new Dimension(180,100));
        alternative3.setPreferredSize(new Dimension(180,100));
        alternative2.setPreferredSize(new Dimension(180,100));
        alternative4.setPreferredSize(new Dimension(180,100));
        questionPanel.setPreferredSize(new Dimension(320,100)); ////
        categoryPanel.setSize(1000,1000);




        /*
        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);

         */

        setTitle("Quiz Game");
        this.setSize(400,600);
        //bottenKnappPanel.setPreferredSize(new Dimension(400, 200));

        backgroundPanel.setBackground( Color.PINK );
        centerPanel.setBackground( Color.PINK );
        southPanel.setBackground( Color.PINK );
        answerAlternativesPanel.setBackground( Color.PINK );
        categoryPanel.setBackground(Color.WHITE);
        categoryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        northPanel.setBackground( Color.PINK );
        bottomButtonPanel.setBackground( Color.PINK );
        titlePanel.setBackground( Color.PINK );
        pointsPanel.setBackground( Color.PINK);
        scoreInputUser1.setBackground(Color.WHITE);
        scoreInputUser2.setBackground(Color.WHITE);
        usernamePanel.setBackground( Color.PINK );
        spacePanel.setBackground( Color.PINK);
        spacePanel2.setBackground( Color.PINK);
        spacePanel3.setBackground( Color.PINK);
        questionPanel.setBackground(Color.WHITE);
        alternative1.setBackground(Color.WHITE);
        alternative2.setBackground(Color.WHITE);
        alternative3.setBackground(Color.WHITE);
        alternative4.setBackground(Color.WHITE);
        continueButton.setBackground(Color.WHITE);
        questionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //pack();
        questionTextArea.setEditable(false);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (correctAnswer = true){
            alternative1.setBackground(Color.GREEN);
        }


    }

    public static void main(String[] args) {

        GameBoardGUI gameBoardGUI = new GameBoardGUI();
    }


}

