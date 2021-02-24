import config.Config;
import model.Person;
import model.Tester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.populate.PopulateService;
import service.testing.TestService;
import util.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Tester tester = (Tester) context.getBean("tester");
        PopulateService service = (PopulateService) context.getBean("populate");
        TestService testService = (TestService) context.getBean("testing");

        Person person = populatePerson();

        service.populate("C:\\Users\\Andrey\\IdeaProjects\\ConsoleStudentTest\\src\\main\\resources\\test.csv");
        testService.test(person);
        ConsoleHelper.printMessage("The result for student " + person.getName() + " " + person.getSurname() + " :");
        ConsoleHelper.printMessage(person.getResult() + " points from 5");
    }

    public static Person populatePerson() {
        Scanner scanner = new Scanner(System.in);
        Person person = null;

        String line;
        ConsoleHelper.printMessage("Enter your name and surname");

        if ((line = scanner.nextLine()) != null) {
            String[] parsedLine = line.split(" ");
            person = new Person(parsedLine[0], parsedLine[1]);
            return person;
        }
        scanner.close();
        return new Person("Default", "Default");
    }
}
