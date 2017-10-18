package ru.job4j.condition;


/**
 * Ttiangle.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    /**
     * Point.
     *
     * @param a - .
     */
    private Point a;
    /**
     * Point.
     *
     * @param b - .
     */
    private Point b;
    /**
     * Point.
     *
     * @param c - .
     */
    private Point c;
    /**
     * Constructor Triangle.
     * @param a - point a .
     * @param b - point b .
     * @param c - point c .
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод должен вычислять расстояние между точками left и right.
     *
     * Для вычисления расстояния использовать формулу.
     * √(xb - xa)^2 + (yb - ya)^2
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * ^ - степень.
     *
     * @param left Точка слева
     * @param right Точка с права.
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return  Math.sqrt(Math.pow(left.getX() - right.getX(), 2) + Math.pow(left.getY() - right.getY(), 2));
    }
    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод должен вычислить прощадь треугольканива.
     *
     * Формула.
     *
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double ab = 0;
        double bc = 0;
        ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        double rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab - расстояние между точками a b.
     * @param ac - расстояние между точками a c.
     * @param bc - расстояние между точками b c.
     * @return true or false.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + bc > ac & bc + ac > ab & ab + ac  > bc;
    }
}
