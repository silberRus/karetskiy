package ru.job4j.index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class ноды префиксного дерева.
 *
 * @author karetskiy
 * @version 1
 * @since 22.07.2018
 */
class NodeTrie {

    /**
     * карта храения индексов.
     * Ключ первая буква.
     */
    private Map<Character, NodeTrie> childs = new HashMap<>();

    /**
     * Индексы в тексте где встречается слово.
     */
    private Set<Integer> indexes = new HashSet<>();

    /**
     * Конструктор иницилизации корневой ноды.
     */
    public NodeTrie() {}

    /**
     * Конструктор иницилизации ноды по слову.
     */
    public NodeTrie(String word, int index) {

        add(word, index);
    }

    /**
     * Добавляет слово в индекс ноды.
     * @param word слово которое индексируем.
     * @param index индекс где встречается слово который нужно запомнить.
     */
    public void add(String word, int index) {

        if(word.length() == 1) {
            indexes.add(index);
        } else {

            NodeTrie node = childs.get(word.charAt(1));
            if (node == null) {
                childs.put(word.charAt(1), new NodeTrie(word.substring(1, word.length()), index));
            } else {
                node.add(word.substring(1, word.length()), index);
            }
        }
    }

    /**
     * Возвращает индексы где всречается слово.
     * @return индексы где всречается слово.
     */
    public Set<Integer> getIndex(String word) {

        NodeTrie child = childs.get(word.charAt(0));
        return child == null ? null :word.length() == 1 ? child.indexes : child.getIndex(word.substring(1, word.length()));
    }
}