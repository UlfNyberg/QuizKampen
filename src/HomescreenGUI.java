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
public class HomescreenGUI extends JPanel implements ActionListener {

    //ImageIcon image = new ImageIcon("  ");
    JFrame frame = new JFrame("Quiz Game");
    JPanel panel = new JPanel();
    JButton button1 = new JButton("Tryck här1");
    //Icon icon = new ImageIcon("/Users/UlfNyberg/Desktop/OOP och JAVA/QuizGUI/src/PicsArt_11-12-09.12.46.jpg");
    //JButton button1 = new JButton(icon);
    //Icon icon2 = new ImageIcon("/Users/UlfNyberg/Desktop/OOP och JAVA/QuizGUI/src/PicsArt_11-12-09.13.16.jpg");
    //JButton button2 = new JButton(icon2);
    JButton button2 = new JButton("Tryck här2");

    JLabel label1 = new JLabel("VÄLKOMMEN!", SwingConstants.CENTER);
    JButton button5 = new JButton(" \n" + "Starta nytt spel!" + "\n ");
    JPanel panel2 = new JPanel();

    JLabel spelarNamnLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel IPadressLabel = new JLabel("Ange ditt IP-nummer:");

    JTextField  spelarNamnTextField = new JTextField("Ex. Mr. Burns", 15);
    JTextField  portNrTextField = new JTextField("Ex. 12345", 15);
    JTextField  IPAdressTextField = new JTextField("Ex. 207.0.0.1", 15);



    HomescreenGUI(){
        this.setLayout(new BorderLayout());
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        panel.setLayout(new BorderLayout());
        add(panel);
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        panel.add(label1, BorderLayout.NORTH);
        panel.add(button5, BorderLayout.SOUTH);
        panel.add(button1, BorderLayout.WEST);
        panel.add(button2, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        panel2.add(spelarNamnLabel);
        panel2.add(spelarNamnTextField);
        panel2.add(IPadressLabel);
        panel2.add(IPAdressTextField);
        panel2.add(portNrLabel);
        panel2.add(portNrTextField);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button5.addActionListener(this);

        frame.setTitle("Quiz Game");
        setSize(400,600);
        panel2.setBackground( Color.PINK );
        panel.setBackground( Color.PINK );
        //pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

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

    public static void main(String[] args) {

        HomescreenGUI homeScreenGUI = new HomescreenGUI();
    }
}
