package ru.job4j.chat;

/**
 * Клас для взаимодействия без консоля через тесты.
 * @author karetskiy
 * @since 02.04.2017
 * @version 1
 */
public class StubApi implements Api {

    /**
     * Вопросы системы на вопрос
     */
    private String[] answser;

    /**
     * Ответы системы на вопрос
     */
    private int countAks = 0;

    /**
     * Последний не занятый индекс ответов
     */
    private int index = 0;

    /**
     * При создании указываем что пользователь вводит в консоль.
     */
    public StubApi(String[] answers) {

        this.answser = answers;
    }

    /**
     * Возвращает сколько ответов выдала система.
     */
    public int getAsksCount() {
        return this.countAks;
    }

    /**
     * Спрашиваем у пользователя вопрос и запоминаем в классе ответ.
     * @return ответ пользователя.
     */
    @Override
    public String input() {
        return answser[index++];
    }

    /**
     * Выводим в консоль ответ.
     * @param answer ответ пользователю.
     */
    @Override
    public void out(String answer) {
        this.countAks++;
        System.out.println(answer);
    }
}