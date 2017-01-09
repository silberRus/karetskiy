package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Karetskiy
* @version 1
* @since 09.01.2017
*/
public class StrTest {

	/**
	* Проверяем вхождение строки когда есть.
	* правильный ответ: true
	*/
	@Test
	public void ifSubPresent() {

		String origin = new String("Съешь мягких фрнцузких булок.");
		String sub = new String("булок");

		Str str = new Str();
		boolean result = str.contains(origin, sub);
		final boolean present = true;

		assertThat(result, is(present));
	}

	/**
	* Проверяем вхождение строки когда нет.
	* правильный ответ: true
	*/
	@Test
	public void ifSubNotPresent() {

		String origin = new String("Съешь мягких фрнцузких булок.");
		String sub = new String("помидор");

		Str str = new Str();
		boolean result = str.contains(origin, sub);
		final boolean present = false;

		assertThat(result, is(present));
	}
}