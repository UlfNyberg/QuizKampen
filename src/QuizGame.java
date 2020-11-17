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

    public Object processInput(Object inputObject) {

        Object theOutput = null;
        int questionIndex = 0;
        int round = 0;

        //TODO: ordningen på states

        if (state == START) {
            playerOne.sendQuestion(questionList.get(0));
            state = WAITINGFORANSWER;

        } else if(state == WAITINGFORANSWER) {
            if (((Answer) inputObject).isCorrect()) {
                //TODO:sätta listor med rätt/fel
                theOutput = true;
            } else {
                theOutput = false;
            }
            state = WAITINGFORCONTINUE;

        }else if(state == WAITINGFORCONTINUE){
            //TODO: vänta på att användaren klickar på nästa
        }

        return theOutput;
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
