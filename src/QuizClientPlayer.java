import QuestionsAndAnswers.Question;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-18
 * Time: 09:50
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizClientPlayer implements  Runnable{

    private Socket socket;

    public QuizClientPlayer (Socket socket){
        this.socket = socket;

    }


    public void run() {

        try (ObjectInputStream in = new ObjectInputStream (socket.getInputStream ())) {

            Object fromServer;

            while ((fromServer = in.readObject ()) != null) {
                if(fromServer instanceof Question){
                    /*
                    questionTextArea.setText (((Question) fromServer).getQuestion ());
                    alternative1.setText(((Question) fromServer).getAnswers().get(0).getText ());
                    alternative2.setText(((Question) fromServer).getAnswers().get(1).getText ());
                    alternative3.setText(((Question) fromServer).getAnswers().get(2).getText ());
                    alternative4.setText(((Question) fromServer).getAnswers().get(3).getText ());

                     */
                }
                else if(fromServer instanceof String){

                    if(((String) fromServer).equalsIgnoreCase("WAIT")){
                        /*
                        questionTextArea.setText ("Waiting");
                        alternative1.setText("wait");
                        alternative2.setText("wait");
                        alternative3.setText("wait");
                        alternative4.setText("wait");
                        //answer1 = null;
                        //answer2 = null;
                        //answer3 = null;
                        //answer4 = null;

                         */

                    }
                }

            }

        } catch (UnknownHostException e) {
            System.err.println ("Don't know about host ");
            System.exit (1);
        } catch (IOException e) {
            System.err.println ("Couldn't get I/O for the connection to ");
            e.printStackTrace ();
            System.exit (1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }
}
