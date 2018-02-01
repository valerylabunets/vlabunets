package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.Arrays;

import java.util.Random;

/**
 * Tracker.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     *  Random number for Id.
     */
    private static final Random RN = new Random();

    /**
     * Method add - реализаущий добавление заявки в хранилище
     * @param item новая заявка
     * @return item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Method generateId - генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Method update - заменяет ячейку в массиве.
     *
     * @param fresh .
     */
    public void update(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }
//        if (item != null) {
//            String id = item.getId();
//            for (int index = 0; index != this.position; index++) {
//                if (item.getId().equals(id)) {
//                    this.items[index] = null;
//                    this.items[index] = item;
//                }
//            }
//        }
    }
    /**
     * Method delete - удаляет ячейку в массиве this.items.
     *
     * @param item .
     */
    public void delete(Item item) {
        if (item != null) {
            String id = item.getId();
            for (int index = 0; index < this.position; index++) {
                if (item != null && this.items[index].getId().equals(id)) {
                    this.items[index] = null;
                }
            }
        }
    }
    /**
     * Method findAll - возвращает копию массива this.items без null элементов.
     *
     * @return result.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
             if (this.items[index] != null) {
             result[count] = this.items[index];
             count++;
             }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }
        /**
         * Method findByName - элементы, у которых совпадает name, копирует в результирующий массив и возвращает его .
         * @param key .
         * @return result .
         */
        public Item[] findByName(String key) {
            Item[] result = new Item[this.position];
            int count = 0;
            if (key != null) {
                for (int index = 0; index < this.position; index++) {
                    String name = this.items[index].getName();
                    if (key != null && name.contains(key)) {
                        result[count] = this.items[index];
                        count++;
                    }
                }
                if (count != 0) {
                    result = Arrays.copyOf(result, count);
                }
            }
            return result;
        }

    /**
     * Method findById - проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     * @param id .
     * @return result.
     */
    //. .
    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}