package ru.job4j.max;
/**
 * Max.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Max.
     * @param first - first param.
     */
    private int first;
    /**
     * Max.
     * @param second - second param.
     */
    private int second;

    /**
     * Method max.
     * @return e.
     */
    public int max() {
        int e = (first > second) ? first : second;
        return e;
    }
}
