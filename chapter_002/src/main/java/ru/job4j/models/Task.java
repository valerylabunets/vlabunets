package ru.job4j.models;
/**
 * Task.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Task extends Item {
    public Task(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
