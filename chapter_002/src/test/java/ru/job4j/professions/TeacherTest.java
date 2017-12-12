package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author Valeriy Labunets (mailto:vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TeacherTest {
    /**
     * Test teach.
     */
    @Test
    public void whenTeacherOlegPetrovichTeachesIvanov() {
        Teacher teacher = new Teacher("Олег Петрович", "Математика", 10, "Иванов");
        String str = teacher.teach();
        String expected = "Учитель Олег Петрович учит Иванов";
        assertThat(str, is(expected));
    }
    @Test
    /**
     * Test addteach.
     */
    public void whenTeacherOlegPetrovichAddteachesIvanov() {
        Teacher teacher = new Teacher("Олег Петрович", "Математика", 10, "Иванов");
        String str = teacher.addteach();
        String expected = "Учитель Олег Петрович занимается с Иванов";
        assertThat(str, is(expected));
    }
}