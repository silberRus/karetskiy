package ru.job4j.nonblock;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class тестирования не блокирующего кеша.
 * @author karetskiy
 * @since 31.10.2018
 * @version 1
 */
public class CacheTest {

    /**
     * Изменим модель  убедимся что версия стала 2 (2 итерации).
     * @throws InterruptedException
     */
    @Test
    public void testNonBlockCache() throws InterruptedException {

        Cache cache = new Cache();
        Base changeModel = new Base(3);

        cache.add(cache.newModel());
        cache.add(cache.newModel());
        cache.add(cache.newModel());
        cache.add(changeModel);

        Thread td1 = new Thread(() -> cache.update((changeModel)));
        Thread td2 = new Thread(() -> cache.update((changeModel)));

        td1.start();
        td2.start();

        td1.join();
        td2.join();

        assertThat(changeModel.getVersion(), is(2));
    }
}