package ru.job4j.tracker;

/**
 * Class ввод информации без консоли.
 * @author karetskiy
 * @since 21.01.2017
 * @version 1
 */

public class StubInput implements Input {

    /**
     * Ответы системы на вопрос
     */
    private String[] answser;

    /**
     * Последний не занятый индекс ответов
     */
    private int index = 0;

    /**
     * При создании указываем что пользователь вводит в консоль.
     */
    public StubInput(String[] answers) {

        this.answser = answers;
    }

    /**
     * Спрашиваем у пользователя вопрос и запоминаем в классе ответ.
     * @param question - вопрос пользователю.
     * @return ответ пользователя.
     */
    public String ask(String question) {

        return answser[index++];
    }
}