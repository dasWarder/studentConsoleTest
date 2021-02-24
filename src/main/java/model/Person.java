package model;

import java.util.*;

public class Person {
    private final String name;
    private final String surname;
    private int counter = 0;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getResult() {
        return counter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", counter=" + counter +
                '}';
    }
}
