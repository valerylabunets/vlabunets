package ru.job4j.professions;

/**
 * Teacher .
 *
 * @author Valeriy Labunets (vavilonw@gmail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * Constructor
     *
     */
    public Teacher(String name, String specialization, int experience) {
        super(name, specialization, experience);
    }
    public String student;
    /**
     * Constructor
     *
     */
    public Teacher(String name, String specialization, int experience, String student) {
        super(name, specialization, experience);
        this.student = student;
    }
    /**
     * Method teach.
     *
     * @return String.
     */
    String teach() {
        return "Учитель " + super.getName() + " учит " + student;
    }
    /**
     * Method addteach.
     *
     * @return String.
     */
    String addteach() {
        return "Учитель " + super.getName() + " занимается с " + student;
    }

}









//    public Teacher(String name, String specialization, int experience) {
//    this.name = name;
//    this.specialization = specialization;
//    this.experience = experience;
//    }


