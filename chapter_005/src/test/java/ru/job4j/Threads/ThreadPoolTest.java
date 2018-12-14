package ru.job4j.Threads;

import org.junit.Test;

/**
 * Class теста тред пула.
 * @author karetskiy
 * @since 14.12.2018
 * @version 1
 */
public class ThreadPoolTest {

    @Test
    public void testRunnableMore() throws InterruptedException {

        ThreadPool pool = new ThreadPool();
        for(int i = 0; i < 100; i++) {
            String name = "task #" + Integer.toString(i);
            pool.work(() -> System.out.println("This " + name));
        }
        while (!pool.tasksTheEnd()) {
        }
    }
}