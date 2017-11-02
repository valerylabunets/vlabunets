package ru.job4j.array;

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
public class ArrayIsSortTest {
    /**
     * Test isSorted.
     */
    @Test
    public void whenArrayIsSortThenTrue() {
        int[] input = {1, 3, 5, 6, 8};
        ArrayIsSort sort = new ArrayIsSort();
        boolean result = sort.isSorted(input);
        assertThat(result, is(true));
    }

}