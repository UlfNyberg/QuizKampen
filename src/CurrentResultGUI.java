import javax.swing.*;
import java.awt.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-13
 * Time: 09:48
 * Project: QuizKampen
 * Copyright: MIT
 */
public class CurrentResultGUI extends JFrame {

    //ImageIcon image = new ImageIcon("  ");
    JFrame frame = new JFrame("Quiz Game");
    JPanel panel3 = new JPanel();

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

    JLabel runda1Label = new JLabel("Runda 1");
    JLabel runda2Label = new JLabel("Runda 2");
    JLabel runda3Label = new JLabel("Runda 3");
    JLabel runda4Label = new JLabel("Runda 4");

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

    JLabel label1 = new JLabel("QUIZ GAME", SwingConstants.CENTER);

    JPanel panel4 = new JPanel();

    JLabel spelarNamnLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel IPadressLabel = new JLabel("Ange ditt IP-nummer:");

    JTextField  spelarNamnTextField = new JTextField("Ex. Mr. Burns", 15);
    JTextField  portNrTextField = new JTextField("Ex. 12345", 15);
    JTextField  IPAdressTextField = new JTextField("Ex. 207.0.0.1", 15);



    CurrentResultGUI(){
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        panel3.setLayout(new BorderLayout());
        add(panel3);
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

        /*
        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);

         */

        setTitle("Quiz Game");
        setSize(400,600);
        panel3.setBackground( Color.PINK );
        panel4.setBackground( Color.PINK );
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (button1.getText().equalsIgnoreCase("Tryck här1")){
            button1.setText("Yo! MTV Raps");
        }
        else if (button2.getText().equalsIgnoreCase("Tryck här2")){
            button2.setText("Wad up?");
        }
        else{
            label1.setText("YAAAAAY! SPELDAGS!");
            button5.setText("NU BÖRJAR SPELET!");
        }

    }

     */

    public static void main(String[] args) {

        CurrentResultGUI currentResultGUI = new CurrentResultGUI();
    }
}

