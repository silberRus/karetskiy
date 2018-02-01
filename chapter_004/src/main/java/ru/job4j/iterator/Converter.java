package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class конвертации итератора итераторов в итератор.
 * @author karetskiy
 * @since 23.01.2018
 * @version 1
 */
public class Converter {

    /**
     * Текущий итератор.
     */
    private Iterator<Integer> current;

    /**
     * Проверяет пустой итератор или закончился.
     * @param it - итератор.
     * @return true если итератор пустой или закончился.
     *
     */
    private boolean isEmpty(Iterator<Integer> it) {
        return it == null || !it.hasNext();
    }

    /**
     * Проверяет доступен или нет следущее значение в итераторе,
     * если значения в итераторе пустые, тогда пропускает их.
     * @param it - итератор итераторов.
     * @return true если доступно следущее значение в итераторе.
     *
     */
    private boolean nextIterator(Iterator<Iterator<Integer>> it) {

        while (it.hasNext()) {
            if (!isEmpty(current) && current.hasNext()) break;
            current = it.next();
        }
        return current != null && current.hasNext();
    }

    /**
     * Конвертирует итератор итераторов чисел в итератор чисел.
     * @param it - итератор итераторов чисел.
     * @return итератор чисел.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

           @Override
            public boolean hasNext() {
                return nextIterator(it);
            }

            @Override
            public Integer next() {

                if (isEmpty(current)) {
                    if (!nextIterator(it)) throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}