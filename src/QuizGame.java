import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

public class QuizGame extends Thread {

    private ServerQuizPlayer playerOne;
    private ServerQuizPlayer playerTwo;

    private static final int START = 0;
    private static final int WAITINGFORANSWER = 1;
    private static final int WAITINGFORCONTINUE = 2;


    private int state = START;

    private Question question;

    public QuizGame(){

        question = new Question("Vad heter jag?");
        question.addAnswer(new Answer("Peter"));
        question.addAnswer(new Answer("Elliot"));
        question.addAnswer(new Answer("Ulf"));
        question.addAnswer(new Answer("Lis"));
        question.getAnswers().get(0).setCorrect();

    }

    public Object processInput(Object inputObject) {

        Object theOutput = null;

        //TODO: ordningen på states

        if (state == START) {
            playerOne.sendQuestion(question);
            state = WAITINGFORANSWER;

        } else if(state == WAITINGFORANSWER) {
            state = WAITINGFORCONTINUE;
            if (((Answer) inputObject).isCorrect()) {
                //TODO:sätta listor med rätt/fel
                theOutput = true;
            } else {
                theOutput = false;
            }

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
}
