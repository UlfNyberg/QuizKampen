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

    JLabel welcomeLabel = new JLabel("VÄLKOMMEN!", SwingConstants.CENTER);
    public JButton initiateNewGameButton = new JButton(" \n" + "Starta nytt spel!" + "\n ");
    JPanel panel2 = new JPanel();

    JLabel nameOfPlayerLabel = new JLabel("Ange ditt namn: ");
    JLabel portNrLabel = new JLabel("Ange ditt portnummer: ");
    JLabel ipaddressLabel = new JLabel("Ange ditt IP-nummer:");

    JTextField nameOfPlayerTextField = new JTextField("Ex. Mr. Burns", 15);
    public JTextField portNrTextField = new JTextField("22222", 15);
    public JTextField ipAddressTextField = new JTextField("127.0.0.1", 15);

    ImageIcon bild1 = new ImageIcon(new ImageIcon ("src/GUI/illustration1.jpg").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon bild2 = new ImageIcon(new ImageIcon ("src/GUI/illustration2.jpg").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon bild3 = new ImageIcon("src/GUI/illustration3.jpg");
    ImageIcon bild4 = new ImageIcon("src/GUI/illustration4.jpg");
    ImageIcon bild5 = new ImageIcon(new ImageIcon ("src/GUI/logopicture.jpg").getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT));
    ImageIcon bild6 = new ImageIcon(new ImageIcon ("src/GUI/welcomePicture.jpg").getImage().getScaledInstance(240,340, Image.SCALE_DEFAULT));



    ImageIcon bwBrainImage = new ImageIcon(new ImageIcon ("src/GUI/bwBrain.jpg").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon yellowBrainImage = new ImageIcon(new ImageIcon ("src/GUI/yellowBrain").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));


    ImageIcon skyBanner1Image = new ImageIcon(new ImageIcon ("src/GUI/skyBanner1.png").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon skyBanner2Image = new ImageIcon(new ImageIcon ("src/GUI/skyBanner2.png").getImage().getScaledInstance(250,850, Image.SCALE_DEFAULT));
    ImageIcon gameNameBannerImage = new ImageIcon(new ImageIcon ("src/GUI/gameNamebanner.png").getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT));
    ImageIcon gameNameCenterImage = new ImageIcon(new ImageIcon ("src/GUI/GameNameCenter.png").getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT));
    ImageIcon gameNameTopImage = new ImageIcon(new ImageIcon ("src/GUI/gameNameTopResized.png").getImage().getScaledInstance(400,600, Image.SCALE_SMOOTH));


    JLabel imagePanel = new JLabel(new ImageIcon("src/GUI/gameNameTopResized.png"));

    JButton imageButton1 = new JButton(bild1);
    JButton imageButton2 = new JButton(bild2);
    JButton imageButton3 = new JButton(bild6);


    public HomescreenGUI(ActionListener al) {
        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        //panel.add(imagePanel);
        add(panel);


        //welcomeLabel.setFont(new Font ("", Font.PLAIN, 30));
        //panel.add(imageButton3, BorderLayout.NORTH);
        panel.add(initiateNewGameButton, BorderLayout.SOUTH);
        panel.add(imageButton1, BorderLayout.WEST);
        //welcomeLabel.setSize(30,30);
        panel.add(imageButton2, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        panel2.add(imageButton3, BorderLayout.NORTH);
        //panel2.add(welcomeLabel);
        panel2.add(nameOfPlayerLabel);
        panel2.add(nameOfPlayerTextField);
        panel2.add(ipaddressLabel);
        panel2.add(ipAddressTextField);
        panel2.add(portNrLabel);
        panel2.add(portNrTextField);
        //panel2.add(imageButton3);
        imageButton1.setPreferredSize(new Dimension(80,50));
        imageButton2.setPreferredSize(new Dimension(80,30));
        imageButton3.setPreferredSize(new Dimension(240,340));
        //imageButton1.setIcon(new ImageIcon(bild1));
        //imageButton1.add(new ImageIcon(bild1));



        imageButton1.addActionListener(al);
        imageButton2.addActionListener(al);
        initiateNewGameButton.addActionListener(al);

        setSize(400, 600);
        panel2.setBackground(Color.PINK);
        panel.setBackground(Color.PINK);


    }
}
