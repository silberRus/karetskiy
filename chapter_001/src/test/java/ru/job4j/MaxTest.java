package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Karetskiy
* @version 1
* @since 04.01.2017
*/
public class MaxTest {

	/**
	* Вычисляем максимум.
	* правильный ответ: 3
	*/
	@Test
	public void whenTwoAndThreeThenhree() {

		int first 	= 2;
		int second 	= 3;

		Max max = new Max();
		int result = max.max(first, second);
		final int area = 3;

		assertThat(result, is(area));
	}

	/**
	* Вычисляем максимум.
	* правильный ответ: 3
	*/
	@Test
	public void whenThreeAndTwoThenhree() {

		int first 	= 3;
		int second 	= 2;

		Max max = new Max();
		int result = max.max(first, second);
		final int area = 3;

		assertThat(result, is(area));
	}
}