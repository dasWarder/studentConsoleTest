package service.testing;

import model.Person;
import model.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.ConsoleHelper;

import java.util.Map;
import java.util.Scanner;

@Service
public class TestService implements Test {
    private Tester tester;

    @Autowired
    public TestService(Tester tester) {
        this.tester = tester;
    }

    @Override
    public void test(Person person) {

        for (Map.Entry<String, String[]> map : tester.getQuestions().entrySet()) {
            ConsoleHelper.printMessage(map.getKey());
            Scanner scanner = new Scanner(System.in);

            String answer = scanner.next();

            if (answer != null) {
                for (int i = 0; i < map.getValue().length; i++) {
                    if (answer.equals(map.getValue()[i])) {
                        person.incrementCounter();
                    }
                }
            }
        }

    }


}
