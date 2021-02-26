package service.populate;

import model.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.populate.Population;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Service
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
                String question = null;

                if(!splitted[0].trim().equals("")) {
                    question = splitted[0];
                } else {
                    throw new IllegalArgumentException("Question can't be empty");
                }


                //check if there are not the empty arr or only with question (without answer(s))
                if(arrLength != 0 && arrLength != 1) {
                    String[] answers = new String[arrLength - 1];

                    for(int i = 1; i <= answers.length; i++) {
                        if(!splitted[i].trim().equals("")) {
                            answers[i - 1] = splitted[i];
                        } else {
                            throw new IllegalArgumentException("The string shouldn't be empty");
                        }
                    }

                    tester.addQuestionAnswers(question, answers);
                } else {
                    throw new IllegalArgumentException("A question or answers include a mistake!");
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


}
