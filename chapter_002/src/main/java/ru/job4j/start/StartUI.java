package ru.job4j.start;

/**
 * StartUI.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI implements Stop {
    /**
     *
     */
    private boolean working = true;
    /**
     * Получение данных от пользователя.
     */
    private Input input;
    /**
     * Хранилище заявок.
     */
    private Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public StartUI(Input input) {
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
//        menu.add(new Exit(this));
        menu.fillActions();
        do {
            menu.show();
//            String answer = this.ui.ask("Выберети номер пункта меню программы");
//            int key = Integer.valueOf(answer);
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
//        while (!menu.exit())
//        while (this.working)
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
//        Input input = new ConsoleInput();
//        new StartUI(input).init();
    }

    @Override
    public void stop() {
        this.working = false;
    }
}

//public class StartUI {
//    private Input input;
//    private MenuTracker menu;
//
//    /**
//     * Constructor.
//     * @param input
//     * @param menu
//     */
//    public StartUI(Input input, MenuTracker menu ){
//        this.input = input;
//        this.menu = menu;
//        this.menu.fillActions();
//    }
//
//    /**
//     *  Start menu
//     */
//    public void run(){
//        do{
//            this.menu.show();
//            this.menu.select(input.ask("Select: ", menu.getMenuRange()));
//        }while(!menu.exit());
//
//
//    }
//
//    public static void main(String[] args) {
//
//        Input input = new ValidateInput();
//        StartUI ui = new StartUI(input,  new MenuTracker(input, new Tracker()));
//
//        ui.run();
//
//    }
//}

