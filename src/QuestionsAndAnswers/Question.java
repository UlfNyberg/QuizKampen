package QuestionsAndAnswers;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-12
 * Time: 15:04
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Question {
    private String question;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer answer4;

    public Question(String question, Answer answer1, Answer answer2, Answer answer3, Answer answer4) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public String getQuestion() {
        return question;
    }
}
