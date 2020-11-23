package NetworkClasses;

import java.io.Serializable;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-12
 * Time: 15:05
 * Project: QuizKampen
 * Copyright: MIT
 */
public class Answer implements Serializable {
    String text;
    boolean correct;

    public Answer(String text) {
        this.text = text;
        this.correct = false;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect() {
        this.correct = true;
    }

    @Override
    public String toString() {
        return text;
    }
}
