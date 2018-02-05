package ru.job4j.start;

/**
 * ValidateInput.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
//    public int ask(String question, int[] range) {
//        int value = -1;
//        boolean valid_data = false;
//        do {
//            try {
//                value = super.ask(question, range);
//                valid_data = true;
//            } catch (MenuOutException moe) {
//                System.out.println("Please select key from menu");
//            } catch (NumberFormatException nfe) {
//                System.out.println("Please enter correct data");
//            }
//
//        } while (valid_data != true);
//
//        return value;
//    }
}
