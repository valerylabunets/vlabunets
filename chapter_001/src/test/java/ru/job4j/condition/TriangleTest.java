package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 *  Test.
 *
 * @author Valery Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Test distance.
     */
    @Test
    public void whenDistanceDiffPointsThen10() {
        // создаем два объекта класса Point.
        Point left = new Point(0, 0);
        Point right = new Point(0, 10);
        // Создаем объект треугольник и в качестве точек передает null.1
        // так как нам не требуется их участие.
        Triangle triangle = new Triangle(null, null, null);
        double rsl = triangle.distance(left, right);
        assertThat(rsl, closeTo(10, 0.01));
    }
    /**
     * Test period.
     */
    public void whenSetThreeDistanceThenTrianglePeriod() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем полупериметр.
        double result = triangle.period(2.0, 2.0, Math.sqrt(8));
        // Задаем ожидаемый результат.
        double expected = (Math.sqrt(8) + 4) / 2;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
    /**
     * Test area.
     */
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

}