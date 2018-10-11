package ru.job4j.Threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class теста потоков на не потокобезопасной коллекции.
 * @author karetskiy
 * @since 12.10.2018
 * @version 1
 */
public class SimpleBlockingQueueTest {

    /**
     * Общая очередь.
     */
    private final SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>(10);

    /**
     * будем одновремено добавлять в очередь и убирать, в результате очередь, должна стать пустой.
     */
    @Test
    public void offerAndPollMoreNum() throws InterruptedException {

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
        });

        Thread customer = new Thread(() -> {

            System.out.println(String.format("start customer. Queue: %s", simpleBlockingQueue.size()));

            while (simpleBlockingQueue.size() > 0) {
                try {

                    System.out.println(String.format("poll is %s size: %s", simpleBlockingQueue.poll(), simpleBlockingQueue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        customer.start();
        producer.start();

        producer.join();
        customer.join();

        assertThat(simpleBlockingQueue.size(), is(0));
    }
}