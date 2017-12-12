package ru.job4j.professions;

/**
 * Profession .
 *
 * @author Valeriy Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    private String name;
    private String specialization;
    private int experience;

    public Profession(String name, String specialization, int experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

}