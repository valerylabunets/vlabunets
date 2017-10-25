package ru.job4j.loop;
/**
 * Paint.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Создание нового объекта format типа {@link StringBuilder}.
     */
    private StringBuilder format = new StringBuilder();
    /**
     * Method piramid.
     * @param  h - высота пирамиды.
     * @return toString() - возвращает все добавленные в него символы и строки в одну строку.
     */
    public String piramid(int h) {

        final String line = System.getProperty("line.separator");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j <= h * 2 - 2; j++) {
                if (j > h - 2 - i && j < h + i) {
                    format.append("^");
                } else {
                    format.append(" ");
                }
            }
            format.append(line);
        }
        return format.toString();
    }

}
