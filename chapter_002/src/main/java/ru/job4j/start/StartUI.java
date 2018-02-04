package ru.job4j.start;

/**
 * StartUI.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
//    /**
//     *
//     */
//    private boolean working = true;

    private MenuTracker menu;
    private Input input;
//    /**
//     * Хранилище заявок.
//     */
//    private Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param menu хранилище заявок.
     */
    public StartUI(Input input, MenuTracker menu) {
        this.input = input;
        this.menu = menu;
        this.menu.fillActions();
//        this.tracker = tracker;
    }
    public StartUI(Input input) {
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
//        Tracker tracker = new Tracker();
//        MenuTracker menu = new MenuTracker(this.input, tracker);
//        menu.add(new Exit(this));
//        menu.fillActions();
        do {
            menu.show();
//            String answer = this.ui.ask("Выберети номер пункта меню программы");
//            int key = Integer.valueOf(answer);
//            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(input.ask("Select: ", menu.getMenuRange()));
        } while (!menu.exit()/*"y".equals(this.input.ask("Exit?(y): "))*/);
//        while (!menu.exit())
//        while (this.working)
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        StartUI ui = new StartUI(input, new  MenuTracker(input, new Tracker()));
        ui.init();
//        new StartUI(new ConsoleInput(), new Tracker()).init();
//        new StartUI(input).init();
    }

//    @Override
//    public void stop() {
//        this.working = false;
//    }
}