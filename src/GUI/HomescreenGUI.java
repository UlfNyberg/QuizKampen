package GUI;

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
public class HomescreenGUI extends JPanel {

    JPanel panel = new JPanel();
    JButton imageButton1 = new JButton("Tryck här1");
    JButton imageButton2 = new JButton("Tryck här2");

    JLabel welcomeLabel = new JLabel("VÄLKOMMEN!", SwingConstants.CENTER);
    public JButton initiateNewGameButton = new JButton(" \n" + "Starta nytt spel!" + "\n ");
    JPanel panel2 = new JPanel();

    JLabel nameOfPlayerLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel IPaddressLabel = new JLabel("Ange ditt IP-nummer:");

    JTextField nameOfPlayerTextField = new JTextField("Ex. Mr. Burns", 15);
    public JTextField portNrTextField = new JTextField("22222", 15);
    public JTextField IPAddressTextField = new JTextField("127.0.0.1", 15);


    public HomescreenGUI(ActionListener al) {
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        add(panel);
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

        imageButton1.addActionListener(al);
        imageButton2.addActionListener(al);
        initiateNewGameButton.addActionListener(al);

        setSize(400, 600);
        panel2.setBackground(Color.PINK);
        panel.setBackground(Color.PINK);
    }
}
