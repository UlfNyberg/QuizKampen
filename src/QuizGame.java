import NetworkClasses.*;
import Util.DAO;
import Util.GameRules;

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
        database = new DAO("src/Util/QuestionsAndAnswers.txt");

    }

    public void run() {
        int round = 1;

        initPlayers();

        while (round <= GameRules.numberOfRounds) {
            if (round % 2 != 0) {
                selectCategory("--Spelare 1 väljer kategori--", 1, 0);
                playSubset("--spelare 1s tur--", 0, playerOneTotalAnswers);
                //TODO: Ska wait vara här eller ska vi köra wait i subset och selectcategory?
                playSubset("--spelare 2s tur--", 1, playerTwoTotalAnswers);
            } else {
                selectCategory("--Spelare 2 väljer kategori--", 0, 1);
                playSubset("--spelare 2s tur--", 1, playerTwoTotalAnswers);
                playSubset("--spelare 1s tur--", 0, playerOneTotalAnswers);
            }
            int playerOneScore = calculateScore(playerOneTotalAnswers);
            int playerTwoScore = calculateScore(playerTwoTotalAnswers);
            playerList.get(0).sendObject(new Result(playerOneTotalAnswers.get(round - 1),
                    playerTwoTotalAnswers.get(round - 1), round, playerOneScore, playerTwoScore));
            playerList.get(1).sendObject(new Result(playerTwoTotalAnswers.get(round - 1),
                    playerOneTotalAnswers.get(round - 1), round, playerTwoScore, playerOneScore));
            System.out.println("--checking score p1--");
            printPlayerAnswers(playerOneTotalAnswers);
            System.out.println("--checking score p2--");
            printPlayerAnswers(playerTwoTotalAnswers);
            round++;
        }
    }

    private void initPlayers() {
        playerList.get(0).sendObject(new Init(null));
        Object fromPlayerOne = playerList.get(0).receiveAnswer();

        playerList.get(1).sendObject(new Init(null));
        Object fromPlayerTwo = playerList.get(1).receiveAnswer();

        playerList.get(0).sendObject(fromPlayerTwo);
        playerList.get(1).sendObject(fromPlayerOne);


    }

    private void printPlayerAnswers(List<List<Boolean>> playerTotalAnswers) {
        for (List<Boolean> list : playerTotalAnswers) {
            System.out.println(list);
        }
    }


    private void selectCategory(String serverMessage, int otherPlayer, int initialPlayer) {
        System.out.println(serverMessage);
        playerList.get(otherPlayer).sendObject(new Wait());
        List<String> categories = database.getRandomCategories(GameRules.numberOfCategories);
        playerList.get(initialPlayer).sendObject(new Category(categories.get(0), categories.get(1)));
        Object fromPlayer = playerList.get(initialPlayer).receiveAnswer();
        String category = ((Category) fromPlayer).getSelectedCategory();
        getQuestions(category);
    }

    private void playSubset(String serverMessage, int initialPlayer, List<List<Boolean>> initialPlayerAnswers) {
        System.out.println(serverMessage);
        answerResult = playOneSet(playerList.get(initialPlayer));
        initialPlayerAnswers.add(List.copyOf(answerResult));
        playerList.get(initialPlayer).sendObject(new Wait());
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

    public int calculateScore(List<List<Boolean>> playerAnswers) {
        int playerScore = 0;
        for (List<Boolean> list : playerAnswers) {
            for (Boolean answer : list) {
                if (answer)
                    playerScore++;
            }
        }
        return playerScore;
    }
}
