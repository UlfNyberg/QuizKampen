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
    JButton imageButton1 = new JButton("Tryck här1");
    //Icon icon = new ImageIcon("/Users/UlfNyberg/Desktop/OOP och JAVA/QuizGUI/src/PicsArt_11-12-09.12.46.jpg");
    //JButton button1 = new JButton(icon);
    //Icon icon2 = new ImageIcon("/Users/UlfNyberg/Desktop/OOP och JAVA/QuizGUI/src/PicsArt_11-12-09.13.16.jpg");
    //JButton button2 = new JButton(icon2);
    JButton imageButton2 = new JButton("Tryck här2");

    JLabel welcomeLabel = new JLabel("VÄLKOMMEN!", SwingConstants.CENTER);
    JButton initiateNewGameButton = new JButton(" \n" + "Starta nytt spel!" + "\n ");
    JPanel panel2 = new JPanel();

    JLabel nameOfPlayerLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel IPaddressLabel = new JLabel("Ange ditt IP-nummer:");

    JTextField  nameOfPlayerTextField = new JTextField("Ex. Mr. Burns", 15);
    JTextField  portNrTextField = new JTextField("12345", 15);
    public JTextField  IPAddressTextField = new JTextField("127.0.0.1", 15);



    HomescreenGUI(){
        this.setLayout(new BorderLayout());
        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(4,2));
        panel.setLayout(new BorderLayout());
        add(panel);
        //BorderLayout.NORTH(setLayout(new FlowLayout());
        panel.add(welcomeLabel, BorderLayout.NORTH);
        panel.add(initiateNewGameButton, BorderLayout.SOUTH);
        panel.add(imageButton1, BorderLayout.WEST);
        panel.add(imageButton2, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        panel2.add(nameOfPlayerLabel);
        panel2.add(nameOfPlayerTextField);
        panel2.add(IPaddressLabel);
        panel2.add(IPAddressTextField);
        panel2.add(portNrLabel);
        panel2.add(portNrTextField);

        imageButton1.addActionListener(this);
        imageButton2.addActionListener(this);
        //initiateNewGameButton.addActionListener(this);

        //frame.setTitle("Quiz Game");
        setSize(400,600);
        panel2.setBackground( Color.PINK );
        panel.setBackground( Color.PINK );
        //pack();
        //frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (imageButton1.getText().equalsIgnoreCase("Tryck här1")){
            imageButton1.setText("Yo! MTV Raps");
        }
        else if (imageButton2.getText().equalsIgnoreCase("Tryck här2")){
            imageButton2.setText("Wad up?");
        }
        else{
            welcomeLabel.setText("YAAAAAY! SPELDAGS!");
            initiateNewGameButton.setText("NU BÖRJAR SPELET!");
        }

    }



    public static void main(String[] args) {

        HomescreenGUI homeScreenGUI = new HomescreenGUI();
    }
}
