package Util;

import NetworkClasses.Question;

import java.util.*;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-13
 * Time: 09:31
 * Project: QuizKampen
 * Copyright: MIT
 */
public class DAO {
    private LinkedHashMap<String, List<Question>> categories;
    private FileImporter fileImporter;

    public DAO(String fileName) {
        this.fileImporter = new FileImporter(fileName);
        this.categories = fileImporter.readFile();
    }

    public List<Question> getCategoryData(String s, int amount) {
        for (Map.Entry<String, List<Question>> entry : categories.entrySet()) {
            if (s.equalsIgnoreCase(entry.getKey())) {
                if (entry.getValue().size() >= amount)
                    return entry.getValue();
            }
        }
        return null;
    }

    public List<Question> getRandomQuestions(String category, int amount) {
        List<Question> questions = new ArrayList<>(List.copyOf(getCategoryData(category, amount)));
        Random random = new Random();
        List<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(questions.size());
            Question questionToBeAdded = questions.get(index);
            questionToBeAdded.setCategory(category);
            randomQuestions.add(questionToBeAdded);
            questions.remove(index);
        }
        return randomQuestions;
    }

    public List<String> getCategories(int amount) {
        List<String> categoriesList = new ArrayList<>();
        for (Map.Entry<String, List<Question>> entry : categories.entrySet()) {
            if (entry.getValue().size() >= amount) {
                categoriesList.add(entry.getKey());
            }
        }
        return categoriesList;
    }

    public List<String> getRandomCategories(int amount) {
        List<String> categoriesList = getCategories(amount);
        Collections.shuffle(categoriesList);
        for (int i = 4; i > amount; i--) {
            categoriesList.remove(i-1);
        }
        return categoriesList;
    }
}
