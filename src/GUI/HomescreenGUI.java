package GUI;

import javax.swing.*;
import java.awt.*;
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

    public JButton initiateNewGameButton = new JButton(" \n" + "Starta nytt spel!" + "\n ");
    JPanel panel2 = new JPanel();

    JLabel nameOfPlayerLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel ipaddressLabel = new JLabel("Ange ditt IP-nummer:");

    public JTextField nameOfPlayerTextField = new JTextField("Ex. Mr. Burns", 15);
    public JTextField portNrTextField = new JTextField("22222", 15);
    public JTextField ipAddressTextField = new JTextField("127.0.0.1", 15);

    ImageIcon bild1 = new ImageIcon(new ImageIcon ("src/GUI/Images/illustration1.jpg").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon bild2 = new ImageIcon(new ImageIcon ("src/GUI/Images/illustration2.jpg").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));

    JButton imageButton1 = new JButton(bild1);
    JButton imageButton2 = new JButton(bild2);

    public HomescreenGUI(ActionListener al) {
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        add(panel);

        panel.add(initiateNewGameButton, BorderLayout.SOUTH);
        panel.add(imageButton1, BorderLayout.WEST);
        panel.add(imageButton2, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        panel2.add(nameOfPlayerLabel);
        panel2.add(nameOfPlayerTextField);
        panel2.add(ipaddressLabel);
        panel2.add(ipAddressTextField);
        panel2.add(portNrLabel);
        panel2.add(portNrTextField);
        imageButton1.setPreferredSize(new Dimension(80,50));
        imageButton2.setPreferredSize(new Dimension(80,30));

        imageButton1.addActionListener(al);
        imageButton2.addActionListener(al);
        initiateNewGameButton.addActionListener(al);
        initiateNewGameButton.setOpaque(true);

        setSize(400, 600);
        panel2.setBackground(Color.PINK);
        panel.setBackground(Color.PINK);
    }
}