package ru.job4j.start;
/**
 * Input.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Input {

    String ask(String question);
    int ask(String question, int[] range);
}
