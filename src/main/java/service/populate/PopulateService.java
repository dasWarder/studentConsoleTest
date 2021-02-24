package service.populate;

import model.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import service.populate.Population;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class PopulateService implements Population {

    private Tester tester;

    @Autowired
    public PopulateService(Tester tester) {
        this.tester = tester;
    }

    //populate Tester with questions and answers
    public void populate(String fileName) {
        //read from CSV by the absolute file name
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while((line = bufferedReader.readLine()) != null) {
                //split the string, 1st element is question, the furthers are answers
                String[] splitted = line.split(";");
                int arrLength = splitted.length;

                //check if there are not the empty arr or only with question (without answer(s))
                if(arrLength != 0 && arrLength != 1) {
                    String[] answers = new String[arrLength - 1];

                    for(int i = 1; i <= answers.length; i++) {
                        answers[i - 1] = splitted[i];
                    }

                    tester.addQuestionAnswers(splitted[0], answers);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


}
