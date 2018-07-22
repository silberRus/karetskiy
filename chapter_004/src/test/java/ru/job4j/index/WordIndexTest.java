package ru.job4j.index;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class теста префиксного дерева.
 * @author karetskiy
 * @since 22.07.2018
 * @version 1
 */
public class WordIndexTest {

    /**
     * Получет сет по тивому методы строки, для того чтобы потом сравнивать в тестах.
     * @return сет с индексами слов где они встречаются по тексту.
     */
    private Set<Integer> setIndexOf(String text, String word) {

        Set<Integer> set = new HashSet<>();
        int ind = text.indexOf(word);

        while (ind >= 0) {
            set.add(ind);
            ind = text.indexOf(word, ind + 1);
        }
        return set;
    }

    /**
     * Сравним типовой поиск с префиксным деревом.
     */
    @Test
    public void getIndexes4Word() {

        final String megaText = "Задача: Есть большой текстовый файл, в котором хранятся различные слова, некоторые из которых – по многу раз.\n" +
                "\n" +
                "Нужно сделать класс WordIndex (можно создавать и другие сопутствующие классы, если это необходимо), который по сути будет являться индексом. Он должен позволять по заданному слову находить все вхождения (позиции) его в файле.\n" +
                "\n" +
                " Данный класс должен компилироваться (исполняться) и иметь следующие методы:\n" +
                "\n" +
                "public void loadFile(String filename); Загрузка данных из файла и построение индекса.\n" +
                "public  Set<Integer> getIndexes4Word(String searchWord); Возвращает список позиций слова в файле. Если данного слова в файле нет, то возвращается null.\n" +
                " Для хранения данных в памяти предлагается использовать Trie (префиксное дерево).\n" +
                "\n" +
                " \n" +
                "\n" +
                "На выходе должен получиться Java проект, в котором будет возможность запустить Unit-тест и проверить его работоспособность.\n" +
                "\n" +
                "Проверьте работу этого приложения с String.indexOf\n" +
                "\n";

        WordIndex wi = new WordIndex(megaText);

        assertThat(wi.getIndexes4Word("Есть"), is(setIndexOf(megaText, "Есть")));
        assertThat(wi.getIndexes4Word("public"), is(setIndexOf(megaText, "public")));
        assertThat(wi.getIndexes4Word("Java"), is(setIndexOf(megaText, "Java")));
    }
}