package ru.job4j.nonblock;

/**
 * Class исключения несоответствий версий в кеше.
 * @author karetskiy
 * @since 31.10.2018
 * @version 1
 */
class OptimisticException extends RuntimeException {

    /**
     * Обрабатывает исключение в момент когда версии в кеше не совпадают.
     * @param err сообщение исключения.
     */
    public OptimisticException(String err) {
        super(err);
    }
}