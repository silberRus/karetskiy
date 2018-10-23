package ru.job4j.index;

import java.util.*;

/**
 * Class индекса слов.
 *
 * @author karetskiy
 * @version 1
 * @since 22.07.2018
 */
public class WordIndex {

    /**
     * Корневая ветка.
     */
    private NodeTrie node = new NodeTrie();

    /**
     * Конструктор, при иницилизации сразу строим индекс.
     */
    public WordIndex(String megaText) {

        char[] chars = megaText.toCharArray();
        String word = "";

        for (int i = 0; i < chars.length; i++) {

            if (Character.isLetterOrDigit(chars[i])) {
                word += String.valueOf(chars[i]);
            } else {
                node.add(" " + word, i - word.length());
                word = "";
            }
        }
    }

    /**
     * Возвращает индексы где встречаются слова.
     * @param searchWord искомое слово.
     * @return индексы где встречается слово.
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        return node.getIndex(searchWord);
    }
}