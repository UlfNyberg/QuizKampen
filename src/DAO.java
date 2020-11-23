import QuestionsAndAnswers.Question;

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

    public List<Question> getCategoryData(String s) {
        for (Map.Entry<String, List<Question>> entry : categories.entrySet()) {
            if (s.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public List<Question> getRandomQuestions (String s, int amount) {
        List<Question> questions = getCategoryData(s);
        Random random = new Random();
        List<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(questions.size());
            randomQuestions.add(questions.get(index));
            questions.remove(index);
        }
        return randomQuestions;
    }

    public List<String> getCategories () {
        List<String> categoriesList = new ArrayList<>();
        for (Map.Entry<String, List<Question>> entry : categories.entrySet()) {
            categoriesList.add(entry.getKey());
        }
        return categoriesList;
    }

    public List<String> getRandomCategories (int amount) {
        List<String> categoriesList = getCategories();
        Collections.shuffle(categoriesList);
        for (int i = 0; i < amount; i++) {
            categoriesList.remove(categoriesList.size()-1-i);
        }
        return categoriesList;
    }
}
