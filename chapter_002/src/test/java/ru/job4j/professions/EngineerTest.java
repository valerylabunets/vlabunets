package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EngineerTest {
    /**
     * Test project.
     */
    @Test
    public void whenEngineerPavlovskiyCreateMost() {
        Engineer engineer = new Engineer("Павловский", "", 15, "Мост");
        String str = engineer.project();
        String expected = "Инженер Павловский создает Мост";
        assertThat(str, is(expected));
    }

}