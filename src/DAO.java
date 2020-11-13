import QuestionsAndAnswers.Question;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-11-13
 * Time: 09:31
 * Project: QuizKampen
 * Copyright: MIT
 */
public class DAO {
    private LinkedHashMap<String, List<Question>> categories;
    private FileImporter fileImporter = new FileImporter("QuestionsAndAnswers.txt");

    public DAO() {
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
}
