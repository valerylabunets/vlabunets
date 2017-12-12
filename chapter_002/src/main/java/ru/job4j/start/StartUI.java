package ru.job4j.start;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Tracker.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDITITEM = "2";
    /**
     * Константа меню для удаления заявки заявки.
     */
    private static final String DELETEITEM = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDITITEM.equals(answer)) {
                this.editItem();
            } else if (DELETEITEM.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findId();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 0);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод выводит на экран все заявки.
     */
    private void showAll() {
        System.out.println("---------- Вывод всех заявок ----------");
        System.out.println(this.tracker.findAll());

    }
    /**
     * Метод запрашивает у пользователя id заявки, после этого меняет найденную заявку на новую.
     */
    private void editItem() {
        System.out.println(("---------- Обновление заявки ---------"));
        String id = this.input.ask("Введите id обновляемой заявки :");
        Item previous = this.tracker.findById(id);
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item next = new Item(name, desc, 1234L);
        next.setId(previous.getId());
        this.tracker.update(next);
        System.out.println("Завка с id " + previous.getId() + " обновлена");
    }
    /**
     * Метод запрашивает у пользователя id заявки, после этого удаляет найденную заявку.
     */
    private void deleteItem() {
        System.out.println(("---------- Удаление заявки ---------"));
        String id = this.input.ask("Введите id удаляемой заявки :");
        Item item = this.tracker.findById(id);
        this.tracker.delete(item);
        System.out.println("Заявка с id" + item.getId() + " удалена");
    }
    /**
     * Метод запрашивает у пользователя id заявки, после этого отображает найденную заявку на экране.
     */
    private void findId() {
        System.out.println("---------- Поиск заявки по id----------");
        String id = this.input.ask("Введите id заявки :");
        System.out.println("Вы искали эту заявку? : " + this.tracker.findById(id));
    }
    /**
     * Метод запрашивает у пользователя id заявки, после этого отображает найденную заявку на экране.
     */
    private void findName() {
        System.out.println(("---------- Поиск заявки по имени ---------"));
        String name = this.input.ask("Введите имя заявки: ");
        this.tracker.findByName(name);
        System.out.println("Вы искали эту заявку?: " + name);
    }
    /**
     * Метод отображает на экране меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
//        System.out.println("Select:");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

