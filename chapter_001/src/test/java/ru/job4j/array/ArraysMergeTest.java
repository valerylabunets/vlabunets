package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author Valery Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArraysMergeTest {
    /**
     * Test merge.
     */
    @Test
    public void whenLeftArrayMergeRightArrayThenCombinedArray() {
        int[] input1 = {4, 5, 6};
        int[] input2 = {1, 2, 3};
        ArraysMerge sorted = new ArraysMerge();
        int[] result = sorted.merge(input1, input2);
        int[] expect = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}