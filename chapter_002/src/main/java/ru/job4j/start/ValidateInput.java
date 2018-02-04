package ru.job4j.start;

/**
 * ValidateInput.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        int value = -1;
        boolean valid_data = false;
        do {
            try {
                value = super.ask(question, range);
                valid_data = true;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data");
            }

        } while (valid_data != true);

        return value;
    }
}
