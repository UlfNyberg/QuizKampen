package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-25
 * Time: 19:47
 * Project: QuizKampen
 * Copyright: MIT
 */
public class WelcomeGUI extends JFrame{


    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    ImageIcon welcomeImage = new ImageIcon(new ImageIcon ("src/GUI/welcomePicture.jpg").getImage().getScaledInstance(400,600, Image.SCALE_DEFAULT));
    ImageIcon welcome2Image = new ImageIcon(new ImageIcon ("src/GUI/welcome2Picture.jpg").getImage().getScaledInstance(400,600, Image.SCALE_DEFAULT));


    JButton imageButton1 = new JButton(welcomeImage);

    JLabel imagePanel = new JLabel(welcomeImage);
    JLabel image2Panel = new JLabel(welcome2Image);

    public WelcomeGUI (){  //ActionListener al
        this.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel.add(imagePanel);
        panel2.add(image2Panel);
        add(panel2);
        add(panel);

        setSize(400, 620);
        setVisible(true);


        imagePanel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                add(panel2);
                panel.setVisible(false);
            }

            public void mouseExited(MouseEvent evt) {
                panel.setVisible(true);
                //panel2.setVisible(false);
                //panel.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        WelcomeGUI wq = new WelcomeGUI();
    }


}
