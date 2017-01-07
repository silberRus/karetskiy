package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Karetskiy
* @version 4
* @since 08.01.2017
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

	/**
	* Проверяем сортировку массива.
	* правильный ответ: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	*/
	@Test
	public void sortingArray() {

		int[] array = {4, 2, 5, 3, 1, 10, 6, 7, 8, 9};

		Turn turn = new Turn();
		int[] resultArray = turn.getSorting(array);
		final int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		assertThat(resultArray, is(expectArray));
	}

	/**
	* Проверяем поворот массива на 90 градусов вправо.
	* правильный ответ:
	*	{3, 2, 1}
	*	{3, 2, 1}
	*	{3, 2, 1}
	*/
	@Test
	public void rotate90R() {

		int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

		Turn turn = new Turn();
		int[][] resultArray = turn.rotate90R(array);
		final int[][] expectArray = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};

		assertThat(resultArray, is(expectArray));
	}

	/**
	* Проверяем создание уникального массива.
	* правильный ответ: {"солнце", "мать", "береза", "лошадь"}
	*/
	@Test
	public void removeDublicatesFromStrings() {

		Turn turn = new Turn();

		final String[] array = {"солнце", "мать", "береза", "лошадь", "мать", "лошадь", "солнце", "мать"};
		final String[] expectArray = {"солнце", "мать", "береза", "лошадь"};

		assertThat(turn.removeDublicates(array), is(expectArray));
	}
}