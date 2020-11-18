import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-18
 * Time: 10:10
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizActionListener implements ActionListener {

    HomescreenGUI homeScreenGUI;
    Socket socket;

    public QuizActionListener (HomescreenGUI homeScreenGUI){
        this.homeScreenGUI = homeScreenGUI;

    }




    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == homeScreenGUI.initiateNewGameButton){
            socket = null;
            try {
                socket = new Socket(homeScreenGUI.IPAddressTextField.getText(),
                        Integer.parseInt(homeScreenGUI.portNrTextField.getText()));
                out = new ObjectOutputStream(socket.getOutputStream ());
                clientListener = new QuizClientPlayer(socket);
                card.show(cardPane, "Result Panel");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Kunde inte ansluta. Försök igen.");
            }
        }


    }
}
