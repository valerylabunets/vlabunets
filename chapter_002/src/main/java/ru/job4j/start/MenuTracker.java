package ru.job4j.start;


import ru.job4j.models.Item;
import ru.job4j.models.Task;

/**
 * MenuTracker.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class AddItem implements UserAction {

    public AddItem(Input input, Tracker tracker) {
    }
    public AddItem() {
    }
    @Override
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
    @Override
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
        this.actions[0] = new AddItem();
        this.actions[1] = new UpdateItem();
        this.actions[2] = new DeletItem();
        this.actions[3] = new ShowItems();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new ExitMemu();
    }

//    public void add(UserAction action) {
//        this.actions[this.position++] = action;
//    }

    public void select(int key) {
        // Смещаем ключ на единицу, т.к. для пользователя отсчет начинается от 1, а в нутри от 0
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

    private class UpdateItem implements UserAction {

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
    private class DeletItem implements UserAction {
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
    private static class ShowItems implements UserAction {
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

    private class FindById implements UserAction {
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

    private class FindByName implements UserAction {
        @Override
        public int key() {
            return 6;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(("---------- Find item by name ---------"));
            String name = input.ask("Please enter the task's name: ");
            Item[] item = tracker.findByName(name);
//            Task task = tracker.findById(StubInput);
            System.out.println("Did you search for this item?: " + name);
//            System.out.printf("Task id: %s name: %s, description: %s \n", item/*, item.getName(), item.getDesc()*/);
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }


    private class ExitMemu implements UserAction {
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

//public class MenuTracker {
//    /** Input interface. */
//    private Input   input;
//    /** Tracker. */
//    private Tracker tracker;
//    /** Menu stages array. */
//    private UserAction[] actions = new UserAction[4];
//    /** Exit flag menu. */
//    private boolean exit;
//
//    /**
//     * Constructor.
//     * @param input  Input interface.
//     * @param tracker Tracker.
//     */
//    public MenuTracker(Input input, Tracker tracker){
//        this.input   = input;
//        this.tracker = tracker;
//        this.exit    = false;
//    }
//    /**
//     *  Adda submenu to main menu.
//     */
//    public void fillActions(){
//        this.actions[0] = new AddItem  ("Add the new item." );
//        this.actions[1] = new ShowItems("Show all items." );
//        this.actions[2] = new FindItem ("Find item.");
//        this.actions[3] = new ExitMenu ("Exit." );
//    }
//
//    /**
//     * It creates and get sequence int value - valid menu stages.
//     * @return int[]
//     */
//    public int[] getMenuRange(){
//        int[] range = new int[this.actions.length];
//        int count = 0;
//        for (count = 0; count < this.actions.length; count++){
//            if (this.actions[count] != null){
//                range[count] = count+1;
//            }else{
//                break;
//            }
//        }
//        range = Arrays.copyOf(range, count+1);
//
//        return range;
//    }
//
//    /**
//     * Choose menu.
//     * @param key
//     */
//    public void select(int key){
//        // Смещаем ключ на единицу, т.к. для пользователя отсчет начинается от 1, а в нутри от 0
//        key -= 1;
//        if(key >= 0 && key < this.actions.length){
//            this.actions[key].execute(this.input, this.tracker);
//        }
//
//    }
//
//    /**
//     *  Print menu.
//     */
//    public void show(){
//        for(UserAction action: this.actions){
//            if (action != null){
//                System.out.println(action.info());
//            }
//        }
//    }
//
//    public boolean exit(){
//        return this.exit;
//    }
//
//    /**
//     *  The class is submenu for exit in the program.
//     */
//    private class ExitMenu extends BaseAction{
//        /**
//         * Add menu name.
//         * @param name
//         */
//        ExitMenu(String name){
//            super(name);
//        }
//        /**
//         * Key.
//         * @return
//         */
//        public int key(){
//            return 4;
//        }
//
//        /**
//         * @param input
//         * @param tracker
//         */
//        public void execute(Input input, Tracker tracker){
//            exit = true;
//        }
//
//    }
//
//}
///**
// * Menu item - add request
// */
//class AddItem extends BaseAction{
//
//    /**
//     * Add menu name.
//     * @param name
//     */
//    AddItem(String name){
//        super(name);
//    }
//    /**
//     * Get key - index in menu array.
//     * @return key.
//     */
//    public int key(){
//        return 1;
//    }
//
//    /**
//     * Add comments to the request.
//     * @param item tracker request.
//     * @param input input stream.
//     */
//    private void addCommentMenu(Item item, Input input){
//
//        String anyMore = null;
//
//        do{
//            String comment = input.ask("Please enter a comment: ");
//            item.addComment(new Comment(comment));
//
//            anyMore = input.ask("Any more?(y/n): ");
//        }while(anyMore.equals("y"));
//    }
//
//    /**
//     * Execute menu item.
//     * @param input tracker request.
//     * @param tracker input stream.
//     */
//    public void execute(Input input, Tracker tracker){
//        String name = input.ask("Please enter task's name ");
//        String desc = input.ask("Please enter task's description ");
//
//        Item task   = new Task(name, desc);
//
//        String commentCmd = input.ask("Would you like add comment?(y/n) ");
//
//        if(commentCmd.equals("y")) {
//            addCommentMenu(task, input);
//
//        }
//        tracker.add(task);
//    }
//}
///**
// * Menu item - show all request.
// */
//class ShowItems extends BaseAction{
//    /**
//     * Add menu name.
//     * @param name
//     */
//    ShowItems(String name){
//        super(name);
//    }
//    /**
//     * Get key - index in menu array.
//     * @return key.
//     */
//    public int key(){
//        return 2;
//    }
//
//    /**
//     * Execute menu item.
//     * @param input tracker request.
//     * @param tracker input stream.
//     */
//    public void execute(Input input, Tracker tracker){
//        Item[] allItem = tracker.getAll();
//        if(allItem.length != 0){
//            for (Item item: allItem){
//                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
//                for(Comment comment : item.getAllComments()){
//                    System.out.println("Comment: " + comment.getComment());
//                }
//            }
//            input.ask("Please enter any key... ");
//        }else{
//            input.ask("Task list is empty. Please enter any key... ");
//        }
//    }
//
//}
//
///**
// * Menu item - find request.
// */
//class FindItem extends BaseAction{
//    /**
//     * Add menu name.
//     * @param name
//     */
//    FindItem(String name){
//        super(name);
//    }
//    /**
//     * Get key - index in menu array.
//     * @return key.
//     */
//    public int key(){
//        return 3;
//    }
//
//    /**
//     * Execute menu item.
//     * @param input tracker request.
//     * @param tracker input stream.
//     */
//    public void execute(Input input, Tracker tracker){
//
//        Integer count = 0;
//
//        String findSubString = input.ask("Please enter task's name or description: ");
//
//        Item[] findItem = tracker.findByFilter(findSubString);
//        /** Последовательность допустимых значений ввода при выборе нужной задачи */
//        int[]  findCountRange = new int[findItem.length];
//
//        if (findItem.length != 0){
//            for (Item item: findItem){
//                if (item != null){
//                    findCountRange[count] = ++count;
//                    System.out.printf("%d. Task id: %s name: %s, description: %s \n",count, item.getId(), item.getName(), item.getDescription());
//                    for(Comment comment : item.getAllComments()){
//                        System.out.println("Comment: " + comment.getComment());
//                    }
//                }
//            }
//            if (count != 0){
//                findCountRange = Arrays.copyOf(findCountRange, count);
//                count = input.ask("Please choose the task: ",findCountRange );
//                EditSubMenu subMenu = new EditSubMenu(findItem[count-1], input, tracker );
//
//                subMenu.run();
//            }
//        }else{
//            input.ask("Task not found...Please enter any key... ");
//        }
//    }
//    /**
//     * Submenu - choose request.
//     * Where we can modify and delete request.
//     */
//    private class EditSubMenu{
//        private Item    item;
//        private Input   input;
//        private Tracker tracker;
//        private UserAction[] subActions = new UserAction[5];
//        private boolean exit = false;
//
//        public EditSubMenu(Item item, Input input, Tracker tracker ){
//            this.item    = item;
//            this.input   = input;
//            this.tracker = tracker;
//            this.exit    = false;
//        }
//        /**
//         *  Add submenu to menu.
//         */
//        private void fillActions(){
//            this.subActions[0] = new ChangeName("Change name.");
//            this.subActions[1] = new ChangeDesc("Change description.");
//            this.subActions[2] = new AddComment("Add comment.");
//            this.subActions[3] = new DeleteItem("Delete task.");
//            this.subActions[4] = new ExitSubMenu("Exit.");
//        }
//
//        /**
//         * It creates and get sequence int value - valid menu stages.
//         * @return valid number for menu
//         */
//        public int[] getMenuRange(){
//            int[] range = new int[this.subActions.length];
//            int count = 0;
//            for (count = 0; count < this.subActions.length; count++){
//                if (this.subActions[count] != null){
//                    range[count] = count+1;
//                }else{
//                    break;
//                }
//            }
//            range = Arrays.copyOf(range, count+1);
//
//            return range;
//        }
//
//        /**
//         * Choose submenu.
//         * @param key
//         */
//        private void select(int key){
//            key -= 1;
//            if(key >= 0 && key < this.subActions.length) {
//                this.subActions[key].execute(this.input, this.tracker);
//            }
//        }
//        /**
//         *  Print submenu.
//         */
//        private void show(){
//            for(UserAction action: subActions){
//                if (action != null){
//                    System.out.println(action.info());
//                }
//            }
//        }
//        /**
//         *  Start menu.
//         */
//        public void run(){
//            this.fillActions();
//            do{
//                this.show();
//                this.select(input.ask("Select: ", this.getMenuRange()));
//            }while(this.exit == false);
//        }
//
//        /**
//         *  The class for modify request name.
//         */
//        private class ChangeName extends BaseAction{
//            /**
//             * Add request name.
//             * @param name
//             */
//            ChangeName(String name){
//                super(name);
//            }
//            /**
//             * Key.
//             * @return
//             */
//            public int key(){
//                return 1;
//            }
//
//            /**
//             * Execute menu.
//             * @param input
//             * @param tracker
//             */
//            public void execute(Input input, Tracker tracker){
//                String name = input.ask("Please enter new task's name ");
//                item.setName(name);
//            }
//        }
//        /**
//         *  The class for modify request description.
//         */
//        private class ChangeDesc extends BaseAction{
//            /**
//             * Add menu name.
//             * @param name
//             */
//            ChangeDesc(String name){
//                super(name);
//            }
//            public int key(){
//                return 2;
//            }
//
//            public void execute(Input input, Tracker tracker){
//                String desc = input.ask("Please enter new task's description ");
//                item.setDescription(desc);
//            }
//        }
//        /**
//         * The class - submenu for add comment to the request.
//         */
//        private class AddComment extends BaseAction{
//            /**
//             * Add request name.
//             * @param name
//             */
//            AddComment(String name){
//                super(name);
//            }
//            /**
//             * Key.
//             * @return
//             */
//            public int key(){
//                return 3;
//            }
//
//            /**
//             * Execute name.
//             * @param input
//             * @param tracker
//             */
//            public void execute(Input input, Tracker tracker){
//                String anyMore = null;
//
//                do{
//                    String comment = input.ask("Please enter a comment: ");
//                    item.addComment(new Comment(comment));
//
//                    anyMore = input.ask("Any more?(y/n): ");
//                }while(anyMore.equals("y"));
//            }
//
//        }
//        /**
//         * The class - submenu for delete request.
//         */
//        private class DeleteItem extends BaseAction{
//            /**
//             * Add request name.
//             * @param name
//             */
//            DeleteItem(String name){
//                super(name);
//            }
//            /**
//             * Key.
//             * @return
//             */
//            public int key(){
//                return 4;
//            }
//
//            /**
//             * Execute name.
//             * @param input
//             * @param tracker
//             */
//            public void execute(Input input, Tracker tracker){
//                tracker.del(item);
//                input.ask("Task delete. Please enter any key... ");
//
//                exit = true;
//            }
//
//        }
//        /**
//         *  The class - submenu for exit from submenu.
//         */
//        private class ExitSubMenu extends BaseAction{
//            /**
//             * Add request name.
//             * @param name
//             */
//            ExitSubMenu(String name){
//                super(name);
//            }
//            /**
//             * Key.
//             * @return
//             */
//            public int key(){
//                return 5;
//            }
//
//            /**
//             * Execute name.
//             * @param input
//             * @param tracker
//             */
//            public void execute(Input input, Tracker tracker){
//                exit = true;
//            }
//        }
//
//    }
//}
