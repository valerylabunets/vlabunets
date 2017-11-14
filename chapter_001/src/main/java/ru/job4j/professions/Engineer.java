package ru.job4j.professions;

public class Engineer extends Profession {
    /**
     * Constructor
     *
     */
    public Engineer(String name, String specialization, int experience) {
        super(name, specialization, experience);
    }

    String project;

    /**
     * Constructor
     *
     */
    public Engineer(String name, String specialization, int experience, String project) {
        super(name, specialization, experience);
        this.project = project;
    }
    /**
     * Method project.
     *
     * @return String.
     */
    String project(Project project) {
        return "Инженер " + super.getName() + " создает " + project;
    }
}
