package ru.job4j.chat;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test класса чата.
 * @author Karetskiy
 * @version 1
 * @since 02.04.2017
 */
public class roboKotTest {

    /**
     * Запросим у чата так чтобы его остановить, потом продолжить и выйти.
     * Посчитаем количество ответов.
     */
    @Test
    public void main() throws Exception {

        RoboKot roboKot = new RoboKot("E:\\java\\projects\\karetskiy\\chapter_003\\src\\test\\java\\ru\\job4j\\chat\\misha.txt");
        String[] asks = {"Привет!","Как дела?","стоп","сейчас без ответа", "Продолжить", "Скажи еще чегонибудь", "Закончить"};

        StubApi api = new StubApi(asks);
        roboKot.play(api);

        assertThat(api.getAsksCount(), is(4));
    }
}