package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Test  add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDesc");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Test update .
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDesc");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDesc");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(next.getId()).getName(), is("test2"));
    }
    /**
     * Test delete .
     */
    @Test
    public void whenDeleteItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        Item item1 = new Item("test2", "testDescription");
        Item item2 = new Item("test3", "testDescription");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1);
        Item[] rst = tracker.findAll();
        Item[] expected = {item, item2};
        assertThat(rst, is(expected));

    }
    /**
     * Test findAll .
     */
    @Test
    public void whenReturnsCopyArrayWithoutNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        // Добавляем заявки в трекер. Теперь в объект проинициализирован id.
        tracker.add(item);
        tracker.add(item2);
        Item[] rst = tracker.findAll();
        Item[] expected = {item, item2};
        assertThat(rst, is(expected));


    }
    /**
     * Test findByName .
     */
    @Test
    public void whenTheSameNamesCopiedToTheNewArrayAndReturnsIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        Item item1 = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] rst = tracker.findByName("test1");
        Item[] expected = {item, item1};
        assertThat(rst, is(expected));

    }
    /**
     * Test findById .
     */
    @Test
    public void whenItFindsTheIdThenItReturnsItOtherwiseReturnsNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        Item item1 = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById("123456");
        String expected = null;
        assertThat(result, is(expected));
    }

}