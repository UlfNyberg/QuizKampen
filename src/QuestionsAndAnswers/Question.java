package QuestionsAndAnswers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-12
 * Time: 15:04
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Question implements Serializable {
    private String question;
    private List<Answer> answers;
    private String category;

    public Question() {}

    public Question(String question) {
        this.question = question;
        answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return question;
    }
}
