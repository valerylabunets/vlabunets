package ru.job4j.loop;
/**
 * Board.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Создание нового объекта format типа {@link StringBuilder}.
     */
    private StringBuilder format = new StringBuilder();
    /**
     * Method paint.
     * @param  width .
     * @param height .
     * @return toString().
     */
    public String paint(int width, int height) {
        final String line = System.getProperty("line.separator");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    format.append("x");
                } else {
                    format.append(" ");
                }
            }
            format.append(line);
        }
        return format.toString();
    }
}
