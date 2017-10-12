package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
        * Test.
        *
        * @author Valery Labunets (mailto:vavilonw@gmail.com)
        * @version $Id$
        * @since 0.1
        */

public class CalculatorTest {
    /**
     * Test Add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test Subtrackt.
     */
    @Test
    public void whenSubOneSubtracktOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtrackt(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
    /**
     * Test Div.
     */
    @Test
    public void whenDivOneDivideOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test Multiple.
     */
    @Test
    public void whenMultOneMultipleOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
}
