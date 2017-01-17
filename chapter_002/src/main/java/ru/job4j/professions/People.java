package ru.job4j.professions;

/**
 * Class человека.
 * @author karetskiy
 * @since 17.01.2017
 * @version 2
 */
public class People {

    /**
     * Профессия человека.
     */
    private Profession profession;

    /**
     * Здоровье и образоване человека.
     */
    private int healt, education;

    /**
     * Простой человек без образования и профессии.
     */
    public People() {

        this.healt = 100;
        this.education = 0;
    }

    /**
     * Создаем сразу заполненного человека.
     * @param healt - Здоровье.
     * @param education - Образование.
     * @param profession - Профессия.
     */
    public People(int healt, int education, Profession profession) {

        this.healt = healt;
        this.education = education;
        this.profession = profession;
    }

    /**
     * Возвращает здоровье.
     * @return здоровье.
     */
    public int getHealt() {

        return this.healt;
    }

    /**
     * Возвращает образование.
     * @return здоровье.
     */
    public int getEducation() {

        return this.education;
    }

    /**
     * Возвращает профессию.
     * @return профессия.
     */
    public Profession getProfession() {

        return this.profession;
    }

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
