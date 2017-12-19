package ru.job4j.start;

import org.junit.Test;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    /**
     * Test unit ADD .
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    /**
     * Test unit SHOWALL .
     */
    @Test
    public void whenUserDisplaysAllItemsOnScreen() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc", 0));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
    }
    /**
     * Test unit EDITEITEM .
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test1", "desc", 0));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    /**
     * Test unit DELETEITEM.
     */
    @Test
    public void whenDeleteThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc", 0));
        Item item1 = tracker.add(new Item("test2", "desc", 0));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }
    /**
     * Test unit FINDID.
     */
    @Test
    public void whenUserFindIdItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc", 0));
        Item item1 = tracker.add(new Item("test2", "desc", 0));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
    /**
     * Test unit FINDNAME.
     */
    @Test
    public void whenUserFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc", 0));
//        Item item1 = tracker.add(new Item("test2", "desc", 0));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
    /**
     * Test unit EXIT.
     */
    @Test
    public void whenUserExitProgram() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc", 0));
        Item item1 = tracker.add(new Item("test2", "desc", 0));
        Input input = new StubInput(new String[]{"6", "6"});
        new StartUI(input, tracker).init();
    }
}