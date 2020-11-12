import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by: Ulf Nyberg
 * Date: 2020-11-12
 * Time: 13:59
 * Project: QuizKampen
 * Copyright: MIT
 */
public class QuizHandler extends Thread{


    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public QuizHandler (Socket socket) {
        this.socket = socket;

    }



    public void run (){
    try {

        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String inputLine, outputLine;

        // Initiate conversation with client
        QuizProtocol kkp = new QuizProtocol();
        outputLine = kkp.processInput(null);
        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
            outputLine = kkp.processInput(inputLine);
            out.println(outputLine);
            //if (outputLine.equals("Bye.")) break;
        }
    } catch (
    IOException e) {
        System.out.println("Cannot connect I/O");
        System.out.println(e.getMessage());

    }
    finally {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    }
}
