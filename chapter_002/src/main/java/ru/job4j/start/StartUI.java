package ru.job4j.start;

/**
 * StartUI.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private MenuTracker menu;
    private Input input;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param menu хранилище заявок.
     */
    public StartUI(Input input, MenuTracker menu) {
        this.input = input;
        this.menu = menu;
        this.menu.fillActions();
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getMenuRange()));
        } while (!menu.exit());
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        StartUI ui = new StartUI(input, new  MenuTracker(input, new Tracker()));
        ui.init();

    }

}