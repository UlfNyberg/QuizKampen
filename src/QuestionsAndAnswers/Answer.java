package QuestionsAndAnswers;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-12
 * Time: 15:05
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Answer {
    String text;
    boolean correct;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

}
