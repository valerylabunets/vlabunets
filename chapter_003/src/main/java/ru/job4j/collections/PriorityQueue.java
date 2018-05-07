package ru.job4j.collections;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * method put
     *  Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {

        tasks.add(task.getPriority(), new Task(task.getDesc()));
    }

    public Task take() {
        return this.tasks.poll();
    }
}
