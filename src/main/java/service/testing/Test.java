package service.testing;

import model.Person;

import java.io.IOException;

public interface Test {
    void test(Person person) throws IOException;
}
