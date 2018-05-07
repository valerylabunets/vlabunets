package ru.job4j.collections;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
