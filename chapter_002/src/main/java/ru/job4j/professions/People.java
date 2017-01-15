package ru.job4j.professions;

/**
 * Class человека.
 * @author karetskiy
 * @since 14.01.2017
 * @version 1
 */
public class People {

    private Profession profession;
    private int healt = 100;
    private int education;

    /**
     * Добавляет образование.
     */
    public void addEducation() {
        this.education++;
    }

    /**
     * Восстанавливает здоровье.
     */
    public void restoreHealth() {
        this.healt = 100;
    }

    /**
     * Работает. В зависимости от профессии выполняет разную работу,
     * при этом уменьшается здоровье.
     */
    public void work() {

        if (this.profession instanceof Doctor) {

            People invalid = new People();
            ((Doctor) this.profession).cure(invalid);

        } else if (this.profession instanceof Teacher) {

            People student = new People();
            ((Teacher) this.profession).learn(student);

        } else if (this.profession instanceof Engineer) {

            ((Engineer) this.profession).work();

        } else {
            return;
        }

        this.profession.addExperience();
        this.healt--;
    }
}
