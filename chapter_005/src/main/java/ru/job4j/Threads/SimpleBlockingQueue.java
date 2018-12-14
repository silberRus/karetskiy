package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class очереди потока на потоконебезопасной коллекции.
 *
 * @author karetskiy
 * @version 4
 * @since 24.10.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    /**
     * Флаг говорит что очередь занята.
     */
    private boolean block = false;

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
     * Конструктор сразу задает размер очереди по умолчанию.
     */
    public SimpleBlockingQueue() {
        this(42);
    }

    /**
     * Блокирует / разблокирует очередь и будит потоки.
     * @param enable если true тогда заблокировать, иначе разбудить.
     */
    private void doBlock(boolean enable) {
        this.block = enable;
        this.notifyAll();
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
     * Определяет пустая очередь или нет.
     * @return true если очередь пустая.
     */
    public boolean isEmpty() {
        synchronized (this) {
            return size() == 0;
        }
    }

    /**
     * Помещаем значение в очередь.
     * @param value помещаемое значение.
     */
    public void offer(T value) throws InterruptedException {

        synchronized (this) {
            while (this.block) {
                System.out.println("wait offer");
                this.wait();
            }
            this.block = true;
            if (this.queue.size() <= this.sizeMax) {
                System.out.println("offer is");
                this.queue.offer(value);
            }
            doBlock(false);
        }
    }

    /**
     * Получаем и удаляем значение из очереди.
     * @return полученное значение.
     */
    public T poll() throws InterruptedException {

        synchronized (this) {
            while (this.block || Thread.interrupted() || this.queue.size() == 0) {
                System.out.println("wait poll");
                this.wait();
            }
            this.block = true;
            T val = queue.poll();
            doBlock(false);
            return val;
        }
    }
}