package Util;

import NetworkClasses.Answer;
import NetworkClasses.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-12
 * Time: 15:32
 * Project: QuizKampen
 * Copyright: MIT
 */
public class FileImporter {
    private BufferedReader br;
    private LinkedHashMap<String, List<Question>> categories;
    private String fileName;

    public FileImporter(String fileName) {
        categories = new LinkedHashMap<>();
        this.fileName = fileName;
    }

    public LinkedHashMap<String, List<Question>> readFile() {
        try {
            br = new BufferedReader(new FileReader(fileName));
            List<Question> list = new ArrayList<>();
            String line;
            Question question = new Question();
            while ((line = br.readLine()) != null) {
                String startOfLine = line.substring(2);
                switch (line.charAt(0)) {
                    case 'K':
                        list = new ArrayList<>();
                        categories.put(startOfLine, list);
                        break;
                    case 'Q':
                        question = new Question(startOfLine);
                        break;
                    case 'A':
                        String[] answers = startOfLine.split(", ");
                        for (String answer : answers) {
                            question.addAnswer(new Answer(answer));
                        }
                        list.add(question);
                        break;
                    case 'S':
                        for (Answer answer : question.getAnswers()) {
                            if (answer.getText().equalsIgnoreCase(startOfLine)) {
                                answer.setCorrect();
                            }
                        }
                }
            }

        } catch (IOException e) {
            System.out.println("Kan inte avläsa filen");
            System.exit(1);
        }
        return categories;
    }

    //For testing
    //Prints the entire map, including the values inside of the lists
    public void printMap() {
        for (Map.Entry<String, List<Question>> entry : categories.entrySet()) {
            System.out.println("Kategori: " + entry.getKey() + ". Frågor: ");
            for (Question question : entry.getValue()) {
                System.out.println(question + " Svar: ");
                for (Answer answer : question.getAnswers()) {
                    if (answer.isCorrect()) {
                        System.out.println(answer + "(Rätt)");
                    } else {
                        System.out.println(answer);
                    }
                }
            }
        }
    }
}
