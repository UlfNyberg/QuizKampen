import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

import java.util.List;

public class QuizGame extends Thread {
    private final DAO database;

    private ServerQuizPlayer playerOne;
    private ServerQuizPlayer playerTwo;

    private static final int START = 0;
    private static final int WAITINGFORANSWER = 1;
    private static final int WAITINGFORCONTINUE = 2;


    private int state = START;

    private List<Question> questionList;

    public QuizGame(){
         database = new DAO("QuestionsAndAnswers.txt");
         getQuestions("Film");
    }

    public void run() {

        int questionIndex = 0;
        int round = 0;
        Object inputObject = null;
        //TODO: ordningen på states


        while(true) {
            System.out.println("--spelare 1s tur--");

            playerOne.sendObject(questionList.get(0));
            playerTwo.sendObject("WAIT");

            inputObject = playerOne.receiveAnswer();
            if (((Answer) inputObject).isCorrect()) {
                System.out.println("spelare 1 svarade rätt");
            } else {
                System.out.println("spelare 1 svarade fel");
            }

            System.out.println("--spelare 2s tur--");

            playerTwo.sendObject(questionList.get(0));
            playerOne.sendObject("WAIT");

            inputObject = playerTwo.receiveAnswer();
            if (((Answer) inputObject).isCorrect()) {
                System.out.println("spelare 2 svarade rätt");
            } else {
                System.out.println("spelare 2 svarade fel");
            }
        }
    }

    public void addPlayer(ServerQuizPlayer player){
        if(playerOne == null)
            playerOne = player;
        else if(playerTwo == null)
            playerTwo = player;
        else
            throw new IllegalArgumentException();

    }

    public void getQuestions(String category) {
        questionList = database.getRandomQuestions(category, 3);
    }
}
