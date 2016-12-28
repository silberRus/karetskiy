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
public class TriangleTest {

	/**
	* Вычисляем площадь треугольника.
	* правильный ответ: 3.5
	*/
	@Test
	public void whenThen() {

		final Triangle triangle = new Triangle(new Point(1d, 2d), new Point(4d, 4d), new Point(3d, 1d));
		final double result = triangle.area();

		assertThat(result, closeTo(0.01, 3.5));
	}
}