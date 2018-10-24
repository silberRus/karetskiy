package ru.job4j.Threads;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class теста потоков на не потокобезопасной коллекции.
 * @author karetskiy
 * @since 25.10.2018
 * @version 3
 */
public class SimpleBlockingQueueTest {

    /**
     * Общая очередь.
     */
    private final SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>(10);

    /**
     * Ждем завершения работы всех нитей и проверям.
     */
    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(50);
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(
                            value -> {
                                try {
                                    queue.offer(value);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    /**
     * будем одновремено добавлять в очередь и убирать, в результате очередь, должна стать пустой.
     */
    @Test
    public void offerAndPollMoreNum() throws InterruptedException {

        Thread customer = new Thread(() -> {

            while (simpleBlockingQueue.size() > 0) {
                try {

                    simpleBlockingQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        customer.start();

        Thread producer = new Thread(() ->
        {
            System.out.println("start producer");

            final int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
            for (int num: nums) {

                try {
                    simpleBlockingQueue.offer(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("offer is %s size: %s", num, simpleBlockingQueue.size()));
            }
            customer.interrupt();
        });

        producer.start();
        customer.join();

        assertThat(simpleBlockingQueue.size(), is(0));
    }
}