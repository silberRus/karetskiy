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
public class TurnTest {

	/**
	* Проверяем переворот массива.
	* правильный ответ: {3, 5, 2, 4}
	*/
	@Test
	public void backArray() {

		int[] array = {4, 2, 5, 3};

		Turn turn = new Turn();
		int[] resultArray = turn.back(array);
		final int[] expectArray = {3, 5, 2, 4};

		assertThat(resultArray, is(expectArray));
	}
}