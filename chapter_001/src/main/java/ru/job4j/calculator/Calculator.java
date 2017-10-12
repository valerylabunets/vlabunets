package ru.job4j.calculator;
/**
 * Calculate.
 *
 * @author Valery Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Calculator.
     * @param args - args.
     */
    private double result;
    /**
     * Method add.
     * @param first .
     * @param second .
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method subtrackt.
     * @param first .
     * @param second .
     */
    public void subtrackt(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div.
     * @param first .
     * @param second .
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple.
     * @param first .
     * @param second .
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult.
     * @param
     * @return result.
     */
    public double getResult() {
        return this.result;
    }

}
