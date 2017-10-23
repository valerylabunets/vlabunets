package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Valery Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     * Test second.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(0, 2);
        int second = 2;
        int expected = second;
        assertThat(result, is(expected));
    }
    /**
     * Test first.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 0);
        int first = 2;
        int expected = first;
        assertThat(result, is(expected));
    }
    /**
     * Test max of three.
     */
    @Test
    public void whenItReturnsTheMaximumOfThree() {
        Max maxim = new Max();
        int result = maxim.maxThree(2, 0, 1);
        int first = 2;
        int expected = first;
        assertThat(result, is(expected));
    }
}
