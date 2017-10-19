package ru.job4j.loop;
/**
 * Counter.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Method add.
     * @param start .
     * @param finish .
     * @return sum.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
          if ((i % 2) == 0) {
              sum = sum + i;
          }
        }
        return sum;
    }
}
