package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class очереди потока на потоконебезопасной коллекции.
 *
 * @author karetskiy
 * @version 1
 * @since 12.10.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    /**
     * Максимальный размер очереди.
     */
    private int sizeMax;

    /**
     * Монитор блокировки.
     */
    private final Object lock = new Object();

    /**
     * Переменная для определения заблокирована очередь или нет.
     */
    private boolean isBlocked = false;

    /**
     * Хранилище очереди.
     */
    @GuardedBy("lock")
    private final Queue<T> queue = new LinkedList<>();

    /**
     * Конструктор, при иниилизации устанавливаем максимальный размер очереди.
     * @param sizeMax максимальный размер очереди.
     */
    public SimpleBlockingQueue(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    /**
     * Возврвщает текущий размер очереди.
     * @return Текущщий размер очереди.
     */
    public int size() {
        synchronized (this.lock) {
            return this.queue.size();
        }
    }

    /**
     * Разблокирует (пробуждает) все другие потоки.
     */
    private void activationOther() {

        synchronized (this.lock) {
            this.isBlocked = false;
            this.lock.notifyAll();
        }
    }

    /**
     * Помещаем значение в очередь.
     * @param value помещаемое значение.
     */
    public void offer(T value) throws InterruptedException {

        synchronized (this.lock) {
            while (this.isBlocked) {
                lock.wait();
            }
            if (this.queue.size() <= this.sizeMax) {
                this.isBlocked = true;
                this.queue.offer(value);
            }
            activationOther();
        }
    }

    /**
     * Получаем и удаляем значение из очереди.
     * @return полученное значение.
     */
    public T poll() throws InterruptedException {

        synchronized (this.lock) {
            while (this.isBlocked || this.queue.size() == 0) {
                lock.wait();
            }
            this.isBlocked = true;
            T val = queue.poll();
            activationOther();
            return val;
        }
    }
}