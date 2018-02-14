package ru.job4j.start;

public abstract class BaseAction implements UserAction {
    private int key;
    private String name;


    public BaseAction(int key, String name) {
       this.name = name;
       this.key = key;
    }

    public BaseAction() {

    }


    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key(), this.name);
    }
}
