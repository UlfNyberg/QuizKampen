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
    JFrame frame = new JFrame("Quiz Game");
    JPanel panel3 = new JPanel();

    JButton valAvSvar1 = new JButton("Alternativ 1");
    JButton valAvSvar2  = new JButton("Alternativ 2");
    JButton valAvSvar3  = new JButton("Alternativ 3");
    JButton valAvSvar4  = new JButton("Alternativ 4");


    JLabel label1 = new JLabel("QUIZ GAME", SwingConstants.CENTER);

    JLabel kategoriLabel = new JLabel("Kategori:");
    JLabel katerogi1 = new JLabel("TV-spel");
    JLabel katerogi2 = new JLabel("Film");
    JLabel katerogi3 = new JLabel("Djur & Natur");
    JLabel katerogi4 = new JLabel("Kategori 4");

    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JLabel SpelNamn = new JLabel("Quiz Game");


    GameBoardGUI(){
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        panel3.setLayout(new BorderLayout());
        add(panel3);
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        panel3.add(label1, BorderLayout.NORTH, SwingConstants.CENTER);
        //panel3.add(button5, BorderLayout.SOUTH);
        //panel3.add(button1, BorderLayout.WEST);
        //panel3.add(button2, BorderLayout.EAST);
        panel3.add(panel4, BorderLayout.CENTER);
        panel4.add(kategoriLabel);
        panel4.add(katerogi1);
        panel3.add(panel5, BorderLayout.SOUTH);
        panel5.setLayout(new GridLayout(2,2));
        panel5.add(valAvSvar1);
        panel5.add(valAvSvar2);
        panel5.add(valAvSvar3);
        panel5.add(valAvSvar4);




        /*
        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);

         */

        setTitle("Quiz Game");
        setSize(400,600);
        panel3.setBackground( Color.PINK );
        panel4.setBackground( Color.PINK );
        panel5.setBackground( Color.PINK );
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        GameBoardGUI gameBoardGUI = new GameBoardGUI();
    }
}

