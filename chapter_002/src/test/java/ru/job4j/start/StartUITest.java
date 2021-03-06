package ru.job4j.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;
import ru.job4j.start.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    private Tracker tracker;

    public StartUITest() {
        this.tracker = new Tracker();
    }

    /**
     * Test unit ADD .
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"1", "test1", "desc", "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
    }

    /**
     * Test unit EDITEITEM .
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test1", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test2", "desc", "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findById(item.getId()).getName(), is("test2"));
    }
    /**
     * Test unit DELETEITEM.
     */
    @Test
    public void whenDeleteThenTrackerHasUpdateValue() {
        Item item = tracker.add(new Item("test1", "desc"));
        Item item1 = tracker.add(new Item("test2", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    /**
     * Test unit SHOWALL .
     */
    @Test
    public void whenUserDisplaysAllItemsOnScreen() {
//        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc"));
        Item item1 = tracker.add(new Item("test2", "desc"));
        Input input = new StubInput(new String[] {"4", "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
    }

    /**
     * Test unit FINDID.
     */
    @Test
    public void whenUserFindIdItem() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Item item1 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"5", item.getId(), "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
    /**
     * Test unit FINDNAME.
     */
    @Test
    public void whenUserFindByNameItem() {
//        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc"));
        Item item1 = tracker.add(new Item("test2", "desc"));
        Input input = new StubInput(new String[]{"6", item.getName(), "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
    /**
     * Test unit EXIT.
     */
    @Test
    public void whenUserExitProgram() {
        Item item = tracker.add(new Item("test1", "desc"));
        Item item1 = tracker.add(new Item("test2", "desc"));
        Input input = new StubInput(new String[]{"7", "7"});
        StartUI ui = new StartUI(input, new  MenuTracker(input, this.tracker));
        ui.init();
    }
}