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
    /**
     * Method max.
     * @param first - first param.
     * @param second - second param.
     * @return max number.
     */
    public int max(int first, int second) {
        return Math.max(first, second);
//        int c = - ((first % second - first) // a);
//        return c * first + (1 - c) * second;
    }
    /**
     * Method max.
     * @param first - first param.
     * @param second - second param.
     * @param third - third param.
     * @return max number.
     */
    public int max(int first, int second, int third) {
        return Math.max(max(), third);
    }
}
