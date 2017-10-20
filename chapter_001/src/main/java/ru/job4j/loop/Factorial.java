package ru.job4j.loop;
/**
 * Factorial.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Method calc.
     * @param n .
     * @return factorial.
     */
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            if (n == 0) {
                return 1;
            } else {
                fact = n * calc(n - 1);
            }
            }
        return fact;
    }
}
