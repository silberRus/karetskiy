package ru.job4j.Threads;

/**
 * Class теста.
 * @author karetskiy
 * @since 24.10.2018
 * @version 1
 */
public class ParallelSearch {

    /**
     * Точка входа программы. Проверим действие producer -> consumer.
     * @param args строковые аргументы.
     */
    public static void main(String[] args) throws InterruptedException {

        /**
         * Объект связи потоков.
         */
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(50);

        final Thread consumer = new Thread(
            () -> {
                while (true) {
                    try {
                        System.out.println(queue.poll());
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        );
        consumer.start();
        new Thread(
            () -> {
                for (int index = 0; index != 3; index++) {
                    try {
                        queue.offer(index);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumer.interrupt();
            }
        ).start();
    }
}