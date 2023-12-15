package com.gabrielanceski.cases;

import com.gabrielanceski.beans.Person;
import com.gabrielanceski.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreamTests {

    @Test
    public void iteratingListsImperative() throws Exception {
        List<Person> people = MockData.getPeople();

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }

    @Test
    public void iteratingListsWithIndex() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    Person person = people.get(index);
                    System.out.println(person);
                });
    }

    @Test
    public void iteratingListsWithoutIndex() throws Exception {
        List<Person> people = MockData.getPeople();
        people.forEach(System.out::println);
    }

    @Test
    public void intStreamIterate() throws Exception {
        IntStream.iterate(1, operand -> operand + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void intStreamWithFilter() throws Exception {
        IntStream.iterate(1, operand -> operand + 2)
                .limit(10)
                .filter(number -> number % 3 == 0) // filtra apenas múltiplos de 3
                .forEach(System.out::println);
    }
}
