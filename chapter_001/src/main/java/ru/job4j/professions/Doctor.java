package ru.job4j.professions;

public class Doctor extends Profession {
    /**
     * Constructor
     *
     */
    public Doctor(String name, String specialization, int experience) {
        super(name, specialization, experience);
    }

    String pacient;
    /**
     * Constructor
     *
     */
    public Doctor(String name, String specialization, int experience, String pacient) {
        super(name, specialization, experience);
        this.pacient = pacient;
    }
    /**
     * Method heal.
     *
     * @return String.
     */
    String heal(Pacient pacient) {
        return "Доктор " + super.getName() + " лечит " + pacient;
    }
    /**
     * Method advises .
     *
     * @return String.
     */
    String advises() {
        return "Доктор " + getName() + " консультирует " + pacient;
    }
}
