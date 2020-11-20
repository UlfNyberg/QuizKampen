import QuestionsAndAnswers.Answer;
import QuestionsAndAnswers.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizGame extends Thread {
    private final DAO database;
    //private ServerQuizPlayer playerOne;
    //private ServerQuizPlayer playerTwo;


    private List<Question> questionList;

    private List<ServerQuizPlayer> playerList = new ArrayList<>();

    private List<Boolean> answerResult = new ArrayList<>();

    private List<List<Boolean>> playerOneTotalAnswers = new ArrayList<>();
    private List<List<Boolean>> playerTwoTotalAnswers = new ArrayList<>();

    public QuizGame() {
        database = new DAO("QuestionsAndAnswers.txt");

    }

    public void run() {
        int round = 1;
        String category = "Film";

        while (round <= GameRules.numberOfRounds) {
            getQuestions(category);
            if (round % 2 != 0) {
                playSubset("--spelare 1s tur--", 1, 0, playerOneTotalAnswers);
                playSubset("--spelare 2s tur--", 0, 1, playerTwoTotalAnswers);
            } else {
                playSubset("--spelare 2s tur--", 0, 1, playerTwoTotalAnswers);
                playSubset("--spelare 1s tur--", 1, 0, playerOneTotalAnswers);
            }
            playerList.get(0).sendObject(new Result(playerOneTotalAnswers.get(round-1), playerTwoTotalAnswers.get(round-1), round));
            playerList.get(1).sendObject(new Result(playerTwoTotalAnswers.get(round-1), playerOneTotalAnswers.get(round-1), round));
            System.out.println("--checking score p1--");
            printPlayerAnswers(playerOneTotalAnswers);
            System.out.println("--checking score p2--");
            printPlayerAnswers(playerTwoTotalAnswers);
            round++;
        }
    }

    private void printPlayerAnswers(List<List<Boolean>> playerTotalAnswers) {
        for (List<Boolean> list : playerTotalAnswers) {
            System.out.println(list);
        }
    }


    private void playSubset(String serverMessage, int otherPlayer, int initialPlayer, List<List<Boolean>> initialPlayerAnswers) {
        System.out.println(serverMessage);
        playerList.get(otherPlayer).sendObject(new Wait());
        answerResult = playOneSet(playerList.get(initialPlayer));
        initialPlayerAnswers.add(List.copyOf(answerResult));
    }

    public void addPlayer(ServerQuizPlayer player) {
        if (playerList.size() < 2)
            playerList.add(player);
        else
            throw new IllegalArgumentException();
    }

    public void getQuestions(String category) {
        questionList = database.getRandomQuestions(category, GameRules.numberOfQuestions);
    }

    public List<Boolean> playOneSet(ServerQuizPlayer player) {
        Object inputObject;
        List<Boolean> answers = new ArrayList<>();

        for (int question = 0; question < GameRules.numberOfQuestions; question++) {
            player.sendObject(questionList.get(question));
            inputObject = player.receiveAnswer();
            if (((Answer) inputObject).isCorrect()) {
                System.out.println("spelare " + player.getUserName() + " svarade rätt");
                answers.add(question, true);
            } else {
                System.out.println("spelare " + player.getUserName() + " svarade fel");
                answers.add(question, false);
            }

        }
        return answers;
    }
}
