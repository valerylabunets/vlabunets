package ru.job4j.condition;
/**
 * Point.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    /**
     * Point.
     *
     * @param x - abscissae.
     */
    private int x;
    /**
     * Point.
     *
     * @param y - ordinates.
     */
     private int y;
    /**
     * Constructor Point.
     * @param x - abscissae.
     * @param y - ordinates.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter X.
     *
     * @return value x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter Y.
     *
     * @return value y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Method is.
     * @param a - coefficient.
     * @param b - coefficient.
     * @return is there a point on this function .
     */
    public boolean is(int a, int b) {
        if (y == a * x + b) {
            return true;
        } else {
            System.out.println("point is not on function");
            return false;
        }
    }
}
