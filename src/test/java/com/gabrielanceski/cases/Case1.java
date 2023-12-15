package com.gabrielanceski.cases;

import com.gabrielanceski.beans.Person;
import com.gabrielanceski.mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

// 1. Encontrar pessoas com idade menor ou igual a 18 anos
// 2. Trocar a implementação para encontrar as primeiras 10 pessoas.
// 3. Ordenar do mais velho para o mais novo.
public class Case1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> youngPeople = Lists.newArrayList();
        final int limit = 10;
        int counter = 0;

        for (Person person : people)
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if (counter == limit) break;
            }

        youngPeople.sort(Comparator.comparing(Person::getAge).reversed());
        for (Person youngPerson : youngPeople)
            System.out.println(youngPerson);
    }

    @Test
    public void declarativeApproachUsingStreams() throws IOException {
        List<Person> people = MockData.getPeople();
        final int limit = 10;

        List<Person> youngPeople = people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(limit)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .toList();
        youngPeople.forEach(System.out::println);
    }
}
