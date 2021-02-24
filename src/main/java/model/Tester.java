package model;
import org.springframework.stereotype.Component;

import java.util.*;


public class Tester {
    private Map<String, String[]> questions = new LinkedHashMap<>();

    public void addQuestionAnswers(String question, String ... answers) {
        questions.put(question, answers);
    }

    public Map<String, String[]> getQuestions() {
        return questions;
    }
}
