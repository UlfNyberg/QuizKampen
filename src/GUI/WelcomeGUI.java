package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-25
 * Time: 19:47
 * Project: QuizKampen
 * Copyright: MIT
 */
public class WelcomeGUI extends JPanel{

    public JPanel panel = new JPanel();
    public JPanel panel2 = new JPanel();

    ImageIcon welcomeImage = new ImageIcon(new ImageIcon ("src/GUI/Images/welcomePicture.jpg").getImage().getScaledInstance(407,600, Image.SCALE_DEFAULT));
    ImageIcon welcome2Image = new ImageIcon(new ImageIcon ("src/GUI/Images/welcome2Picture.jpg").getImage().getScaledInstance(407,600, Image.SCALE_DEFAULT));

    JLabel image = new JLabel(welcomeImage);
    public JLabel image2 = new JLabel(welcome2Image);

    public WelcomeGUI (MouseAdapter ma){
        this.setLayout(new BorderLayout());
        panel.add(image);
        panel2.add(image2);
        add(panel2);
        add(panel);
        this.addMouseListener(ma);
        setSize(400, 620);
        setVisible(true);
    }
}
