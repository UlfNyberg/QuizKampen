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


    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    ImageIcon welcomeImage = new ImageIcon(new ImageIcon ("src/GUI/welcomePicture.jpg").getImage().getScaledInstance(400,600, Image.SCALE_DEFAULT));
    ImageIcon welcome2Image = new ImageIcon(new ImageIcon ("src/GUI/welcome2Picture.jpg").getImage().getScaledInstance(400,600, Image.SCALE_DEFAULT));


    JButton imageButton1 = new JButton(welcomeImage);

    JLabel image = new JLabel(welcomeImage);
    public JLabel image2 = new JLabel(welcome2Image);

    public WelcomeGUI (MouseAdapter ma){
        this.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel.add(image);
        panel2.add(image2);
        add(panel2);
        add(panel);
        image2.addMouseListener(ma);
        setSize(400, 620);
        setVisible(true);


        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                add(panel2);
                panel.setVisible(false);
            }

            public void mouseExited(MouseEvent evt) {
                panel.setVisible(true);
            }


        });
    }



}
