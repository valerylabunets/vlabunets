package ru.job4j.shapes;
/**
 * Paint.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    private Shape shape;
    public Paint(Shape shape) {
        this.shape = shape;
    }
    public Paint() {

    }

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}
