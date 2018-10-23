package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class очереди потока на потоконебезопасной коллекции.
 *
 * @author karetskiy
 * @version 3
 * @since 24.10.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    /**
     * Максимальный размер очереди.
     */
    private int sizeMax;

    /**
     * Хранилище очереди.
     */
    @GuardedBy("this")
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
        synchronized (this) {
            return this.queue.size();
        }
    }

    /**
     * Помещаем значение в очередь.
     * @param value помещаемое значение.
     */
    public void offer(T value) throws InterruptedException {

        synchronized (this) {
            while (Thread.interrupted()) {
                System.out.println("wait offer");
                this.wait();
            }
            if (this.queue.size() <= this.sizeMax) {
                System.out.println("offer is");
                this.queue.offer(value);
            }
            this.notifyAll();
        }
    }

    /**
     * Получаем и удаляем значение из очереди.
     * @return полученное значение.
     */
    public T poll() throws InterruptedException {

        synchronized (this) {
            while (Thread.interrupted() || this.queue.size() == 0) {
                System.out.println("wait poll");
                this.wait();
            }
            T val = queue.poll();
            this.notifyAll();
            return val;
        }
    }
}