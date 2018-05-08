package ru.job4j.collections;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Valeriy", "Ivanov", "038534872", "Kharkov")
        );
        List<Person> persons = phones.find("Valeriy");
        assertEquals(persons.iterator().next().getSurname(), "Ivanov");
    }
}