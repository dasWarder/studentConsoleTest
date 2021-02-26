package populate;

import config.Config;
import model.Tester;
;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import service.populate.PopulateService;

import static org.junit.jupiter.api.Assertions.*;




@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
public class PopulateServiceTest {

    @Autowired
    private Tester tester;

    @Autowired
    private PopulateService populateService;

    private static final String fileName = "C:\\Users\\Andrey\\IdeaProjects\\ConsoleStudentTest\\src\\test\\resources\\test.csv";
    private static final String fileWithoutAnswersName = "C:\\Users\\Andrey\\IdeaProjects\\ConsoleStudentTest\\src\\test\\resources\\test1.csv";
    private static final String fileWithoutQuestion = "C:\\Users\\Andrey\\IdeaProjects\\ConsoleStudentTest\\src\\test\\resources\\test2.csv";

    @BeforeEach
    public void populateTester() {
        populateService.populate(fileName);
    }

    @Test
    public void populateEqualsKeys() {
        assertEquals(tester.getQuestions().keySet(), TestData.getPopulatedMap().keySet());
    }

    @Test
    public void populateEqualsAnswers() {
        String[] answersThree = tester.getQuestions().get(TestData.questionThree);
        assertEquals(answersThree[0], TestData.answerThreeOne);
        assertEquals(answersThree[1], TestData.answerThreeTwo);
    }

    @Test
    public void populateGetWrongQuestion() {
        assertEquals(false, tester.getQuestions().containsKey(TestData.notFoundQuestion));
    }

    @Test
    public void populateWithoutAnswers() {
        assertThrows(IllegalArgumentException.class, () -> populateService.populate(fileWithoutAnswersName));
    }

    @Test
    public void populateWithoutQuestion() {
        assertThrows(IllegalArgumentException.class, () -> populateService.populate(fileWithoutQuestion));
    }
}
