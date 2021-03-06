package ru.job4j.collections;


import java.util.ArrayList;
import java.util.List;

/**
 * PhoneDictionary.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * method find
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person i: persons) {
            if (i.getName().contains(key) || i.getSurname().contains(key)) {
                result.add(i);
            }
            if (i.getAddress().contains(key) || i.getPhone().contains(key)) {
                result.add(i);
            }
         }
        return result;
    }
}
