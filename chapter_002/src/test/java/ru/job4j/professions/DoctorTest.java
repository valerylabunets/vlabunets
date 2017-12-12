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
public class DoctorTest {
    /**
     * Test heal.
     */
    @Test
    public void whenDoctorRihterHealPetrov() {
        Doctor doctor = new Doctor("Рихтер", "", 12, "Петров");
        String str = doctor.heal();
        String expected = "Доктор Рихтер лечит Петров";
        assertThat(str, is(expected));
    }
    /**
     * Test heal.
     */
    @Test
    public void whenDoctorRihterAdvisesPetrov() {
        Doctor doctor = new Doctor("Рихтер", "", 12, "Петров");
        String str = doctor.advises();
        String expected = "Доктор Рихтер консультирует Петров";
        assertThat(str, is(expected));
    }

}