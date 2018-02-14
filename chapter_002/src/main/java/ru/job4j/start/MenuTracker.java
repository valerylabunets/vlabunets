package ru.job4j.start;


import ru.job4j.models.Item;
import ru.job4j.models.Task;

import java.util.Arrays;

/**
 * MenuTracker.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class AddItem extends BaseAction {

    public AddItem() {
    }

    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println(("---------- Add new Item ---------"));
        String name = input.ask("Please enter task's name ");
        String desc = input.ask("Please enter task's description ");
        Item item = tracker.add(new Task(name, desc));
        System.out.println("Added task: ");
        System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDesc());
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Add new Item");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private boolean exit;
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.exit = false;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem();
        this.actions[position++] = new UpdateItem();
        this.actions[position++] = new DeletItem();
        this.actions[position++] = new ShowItems();
        this.actions[position++] = new FindById();
        this.actions[position++] = new FindByName();
        this.actions[position++] = new ExitMemu();
    }
    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    public int[] getMenuRange() {
        int[] range = new int[this.actions.length];
        int count = 0;
        for (count = 0; count < this.actions.length; count++) {
            if (this.actions[count] != null) {
                range[count] = count + 1;
            } else {
                break;
            }
        }
        range = Arrays.copyOf(range, count + 1);
        return range;
    }

    public void select(int key) {
        key--;
        if (key >= 0 && key < this.actions.length) {
            this.actions[key].execute(this.input, this.tracker);
        }
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public boolean exit() {
        return this.exit;
    }

    private class UpdateItem extends BaseAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(("---------- Edit item ---------"));
            String id = input.ask("Please enter the task's id: ");
            String name = input.ask("Please enter new task's name: ");
            String desc = input.ask("Please enter new task's desc:");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.update(task);
            System.out.println("Task id " + task.getId() + " updated");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }
    private class DeletItem extends BaseAction {
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(("---------- Delete item ---------"));
            String id = input.ask("Please enter the task's id:");
            Item item = tracker.findById(id);
            tracker.delete(item);
            System.out.println("Task id" + item.getId() + " delete");
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    private static class ShowItems extends BaseAction {
        @Override
        public int key() {
            return 4;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- All items ---------");
            for (Item item: tracker.findAll()) {
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDesc());
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private class FindById extends BaseAction {
        @Override
        public int key() {
            return 5;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Find item by Id ----------");
            String id = input.ask("Please enter the task's id:");
            Item item = tracker.findById(id);
            System.out.println("Did you search for this item?:");
            System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDesc());
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }

    private class FindByName extends BaseAction {
        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(("---------- Find item by name ---------"));
            String name = input.ask("Please enter the task's name: ");
            Item[] item = tracker.findByName(name);
            System.out.println("Did you search for this item?: " + name);
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }

    private class ExitMemu extends BaseAction {
         @Override
        public int key() {
            return 7;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You have selected the menu paragraf Exit Program. Bye");
            exit = true;
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}