package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Test.
*
* @author Karetskiy
* @version 1
* @since 28.12.2016
*/
public class PointTest {

	/**
	* Вычисляем длину отрезка.
	* правильный ответ: 2.8284271247461903
	*/
	@Test
	public void whenPointTwoTwoToFourFourThen() {

		final Point pointA = new Point(2d, 2d);
		final Point pointB = new Point(4d, 4d);

		final double result = pointA.distanceTo(pointB);

		assertThat(result, closeTo(0.04, 2.8));
	}
}