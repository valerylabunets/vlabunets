package ru.job4j.loop;
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
public class CounterTest {
    /**
     * Test add.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        int start = 1;
        int finish = 10;
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expect = 30;
        assertThat(result, is(expect));

    }


}