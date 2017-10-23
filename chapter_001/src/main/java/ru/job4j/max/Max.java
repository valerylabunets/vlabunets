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
     * Method max.
     * @param first - first param.
     * @param second - second param.
     * @return e.
     */
    public int max(int first, int second) {
        int e = (first > second) ? first : second;
        return e;
    }
      /**
     * Method max.
     * @param first - first param.
     * @param second - second param.
     * @param third - third param.
     * @return max number.
     */
    public int maxThree(int first, int second, int third) {
        return max(third, max(first, second));
    }
}