package populate;

import java.util.*;

public class TestData {

    public static final String questionOne = "The name of mountain in Japan?";
    public static final String answerOne = "Fuji";
    public static final String questionTwo = "When the WWII started?";
    public static final String answerTwo = "1939";
    public static final String questionThree = "What Korea do you know?";
    public static final String answerThreeOne = "South";
    public static final String answerThreeTwo = "North";
    public static final String questionFour = "What distance from the monitor is correct for eyes?";
    public static final String answerFourOne = "45";
    public static final String answerFourTwo = "60";
    public static final String questionFive = "What the name of a Austria capital?";
    public static final String answerFive = "Vienna";
    public static final String notFoundQuestion = "Wrong question";

    private static Map<String, String[]> questionsTest = new LinkedHashMap<>();

    public static Map<String, String[]> getPopulatedMap() {
        questionsTest.put(questionOne, new String[]{answerOne});
        questionsTest.put(questionTwo, new String[]{answerTwo});
        questionsTest.put(questionThree, new String[]{answerThreeOne, answerThreeTwo});
        questionsTest.put(questionFour, new String[]{answerFourOne, answerFourTwo});
        questionsTest.put(questionFive, new String[]{answerFive});

        return questionsTest;
    }

}
