package ru.job4j.collections;



import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Valeriy", "Labunets", "038534872", "Kharkov")
        );
        List<Person> persons = phones.find("Valeriy");
        assertThat(persons.iterator().next().getSurname(), is("Labunets"));
    }
}
