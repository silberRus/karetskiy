package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Karetskiy
* @version 1
* @since 05.01.2017
*/
public class CounterTest {

	/**
	* Вычисляем суммы от 2 до 7.
	* правильный ответ: 12
	*/
	@Test
	public void whenTwoDoSevenThenTwelve() {

		int first 	= 2;
		int second 	= 7;

		Counter count = new Counter();
		int result = count.add(first, second);
		final int area = 12;

		assertThat(result, is(area));
	}

	/**
	* Вычисляем факториал 5.
	* правильный ответ: 120
	*/
	@Test
	public void fctorialFiveIsOneHundredAndTwenty() {

		int first 	= 5;

		Counter count = new Counter();
		int result = count.factorial(first);
		final int area = 120;

		assertThat(result, is(area));
	}
}