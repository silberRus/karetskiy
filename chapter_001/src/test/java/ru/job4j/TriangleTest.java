package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Test.
*
* @author Karetskiy
* @version 2
* @since 30.12.2016
*/
public class TriangleTest {

	/**
	* Вычисляем когда треугольник не возможен.
	*/
	@Test
	public void whenCALong() {

		Triangle triangle = new Triangle(new Point(0d, 0d), new Point(1d, 1d), new Point(2d, 2d));
		double result = triangle.area();
		final double area = 0d;

		assertThat(result, is(area));
	}

	/**
	* Проверяем площадь правильного треугольника.
	* правильный ответ: 1.5
	*/
	@Test
	public void whenTriangleGood() {

		Triangle triangle = new Triangle(new Point(3d, 3d), new Point(2d, 2d), new Point(0d, 3d));
		double result = triangle.area();
		final double area = 1.5;

		assertThat(result, closeTo(area, 0.1));
	}
}