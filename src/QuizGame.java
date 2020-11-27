import NetworkClasses.*;
import Util.DAO;
import Util.GameRules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizGame extends Thread {
    private final DAO database;

    private List<Question> questionList;
    private List<ServerQuizPlayer> playerList = new ArrayList<>();
    private List<Boolean> answerResult = new ArrayList<>();
    private List<List<Boolean>> playerOneTotalAnswers = new ArrayList<>();
    private List<List<Boolean>> playerTwoTotalAnswers = new ArrayList<>();

    protected GameRules gameRules;

    public QuizGame(GameRules gameRules) {
        database = new DAO("src/Util/QuestionsAndAnswers.txt");
        this.gameRules = gameRules;
    }

    public void run() {
        System.out.println("Running");
        int round = 1;
        int playerOneScore = 0;
        int playerTwoScore = 0;

        try {
            initPlayers();

            while (round <= gameRules.getNumberOfRounds()) {
                if (round % 2 != 0) {
                    selectCategory("--Spelare 1 väljer kategori--", 1, 0);
                    playSubset("--spelare 1s tur--", 0, playerOneTotalAnswers);
                    playSubset("--spelare 2s tur--", 1, playerTwoTotalAnswers);
                } else {
                    selectCategory("--Spelare 2 väljer kategori--", 0, 1);
                    playSubset("--spelare 2s tur--", 1, playerTwoTotalAnswers);
                    playSubset("--spelare 1s tur--", 0, playerOneTotalAnswers);
                }
                playerOneScore = calculateScore(playerOneTotalAnswers);
                playerTwoScore = calculateScore(playerTwoTotalAnswers);
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
            if (playerOneScore > playerTwoScore) {
                playerList.get(0).sendObject(new EndGame(EndGame.EndGameStates.winner));
                playerList.get(1).sendObject(new EndGame(EndGame.EndGameStates.loser));
            } else if (playerOneScore < playerTwoScore) {
                playerList.get(0).sendObject(new EndGame(EndGame.EndGameStates.loser));
                playerList.get(1).sendObject(new EndGame(EndGame.EndGameStates.winner));
            } else {
                playerList.get(0).sendObject(new EndGame(EndGame.EndGameStates.draw));
                playerList.get(1).sendObject(new EndGame(EndGame.EndGameStates.draw));
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Avslutar matchen");
            try {
                playerList.get(0).sendObject(new EndGame(EndGame.EndGameStates.disconnected));
            } catch (IOException ioException) {
                System.out.println("Kunde inte skicka meddelande till spelare 1");
            }
            try {
                playerList.get(1).sendObject(new EndGame(EndGame.EndGameStates.disconnected));
            } catch (IOException ioException) {
                System.out.println("Kunde inte skicka meddelande till spelare 2");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initPlayers() throws IOException, ClassNotFoundException {
        playerList.get(0).sendObject(new Init(null,gameRules));
        Object fromPlayerOne = playerList.get(0).receiveAnswer();

        playerList.get(1).sendObject(new Init(null,gameRules));
        Object fromPlayerTwo = playerList.get(1).receiveAnswer();

        playerList.get(0).sendObject(fromPlayerTwo);
        playerList.get(1).sendObject(fromPlayerOne);


    }

    private void printPlayerAnswers(List<List<Boolean>> playerTotalAnswers) {
        for (List<Boolean> list : playerTotalAnswers) {
            System.out.println(list);
        }
    }


    private void selectCategory(String serverMessage, int otherPlayer, int initialPlayer) throws NullPointerException, IOException, ClassNotFoundException {
        System.out.println(serverMessage);
        playerList.get(otherPlayer).sendObject(new Wait());
        List<String> categories = database.getRandomCategories(gameRules.getNumberOfCategories());
        switch (categories.size()) {
            case 2:
                playerList.get(initialPlayer).sendObject(new Category(categories.get(0), categories.get(1), null, null));
                break;
            case 3:
                playerList.get(initialPlayer).sendObject(new Category(categories.get(0), categories.get(1), categories.get(2), null));
                break;
            case 4:
                playerList.get(initialPlayer).sendObject(new Category(categories.get(0), categories.get(1), categories.get(2), categories.get(3)));
        }
        Object fromPlayer = playerList.get(initialPlayer).receiveAnswer();
        if(fromPlayer == null) {
            throw new NullPointerException();
        }
        String category = ((Category) fromPlayer).getSelectedCategory();
        getQuestions(category);
    }

    private void playSubset(String serverMessage, int initialPlayer, List<List<Boolean>> initialPlayerAnswers) throws IOException, ClassNotFoundException {
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
        questionList = database.getRandomQuestions(category, gameRules.getNumberOfQuestions());
    }

    public List<Boolean> playOneSet(ServerQuizPlayer player) throws IOException, ClassNotFoundException {
        Object inputObject;
        List<Boolean> answers = new ArrayList<>();

        for (int question = 0; question < gameRules.getNumberOfQuestions(); question++) {
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
