package ru.job4j.shapes;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * Test  draw.
     */
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("++++")
                .append("+  +")
                .append("+  +")
                .append("++++")
                .append(System.lineSeparator()).toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                  .append("   ^   ")
                  .append("  ^ ^  ")
                  .append(" ^   ^ ")
                  .append("^^^^^^^")
                  .append(System.lineSeparator()).toString()));
        System.setOut(stdout);
    }
}