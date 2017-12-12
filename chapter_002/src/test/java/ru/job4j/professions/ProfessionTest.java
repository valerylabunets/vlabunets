package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ProfessionTest {
    /**
     * Test getName .
     */
    @Test
    public void whenNameOlegPetrovich() {
        Profession profession = new Profession("Олег Петрович", "", 0);
        String result = profession.getName();
        String expected = "Олег Петрович";
        assertThat(result, is(expected));
    }

}