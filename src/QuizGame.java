import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

import java.util.List;

public class QuizGame extends Thread {
    private static final int NUMBER_OF_QUESTIONS = 3;
    private final DAO database;

    //private ServerQuizPlayer playerOne;
    //private ServerQuizPlayer playerTwo;

    private List<ServerQuizPlayer> playerList;

    private List<Question> questionList;
    private List<Boolean> answerResult;

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
            playerList.get(1).sendObject("WAIT");
            playOneSet(playerList.get(0));

            System.out.println("--spelare 2s tur--");
            playerList.get(0).sendObject("WAIT");
            playOneSet(playerList.get(1));

        }
    }

    public void addPlayer(ServerQuizPlayer player){
        if(playerList.size() < 2)
            playerList.add(player);
        else
            throw new IllegalArgumentException();
    }

    public void getQuestions(String category) {
        questionList = database.getRandomQuestions(category, NUMBER_OF_QUESTIONS);
    }

    public void playOneSet(ServerQuizPlayer player){
        Object inputObject;

        for(int question = 0; question < NUMBER_OF_QUESTIONS; question++) {
            player.sendObject(questionList.get(question));
            inputObject = player.receiveAnswer();
            if (((Answer) inputObject).isCorrect()) {
                System.out.println("spelare " + player.getUserName() + " svarade rätt");
                answerResult.add(question,true);
            } else {
                System.out.println("spelare " + player.getUserName() + " svarade fel");
                answerResult.add(question,false);
            }

        }

    }
}
