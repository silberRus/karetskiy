package ru.job4j.Threads;

import java.util.LinkedList;
import java.util.List;

/**
 * Class тред пул заданий.
 * Управляет очередью заданий.
 *
 * @author karetskiy
 * @version 1
 * @since 14.12.2018
 */

public class ThreadPool {

    /**
     * Список тредов.
     */
    private final List<Thread> threads = new LinkedList<>();

    /**
     * Очередь заданий.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    /**
     * Означет что пулл запущен.
     */
    private volatile boolean running = true;

    /**
     * Иницилизируем пул и сразу запускаем потоки на обработку задач.
     */
    public ThreadPool(){

        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {

            Thread thread = new Thread(() -> {

                while (running) {
                    try {
                        tasks.poll().run();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    /**
     * Получаем задачу на обработку в пул.
     * @param job работа которую будет выполнять задание.
     */
    public void work(Runnable job) throws InterruptedException {
        if (running) {
            tasks.offer(job);
        }
    }

    /**
     * Останавливает работу пула.
     */
    public void shutdown(){
        running = false;
        threads.forEach(thread -> notify());
    }

    /**
     * Проверяет работает пул или нет.
     * @return true если пул работает, false иначе.
     */
    public boolean tasksTheEnd() {
        return tasks.isEmpty();
    }
}