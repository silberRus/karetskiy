package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Karetskiy
* @version 2.0
* @since 19.12.2016
*/
public class CalculateTest {

	/**
	* Test сложения.
	*/
	@Test
	public void whenAddTwoToFourThenSix() {

		final Calculate calc = new Calculate();
		calc.add(2, 4);

		final double result = calc.getResult();
		assertThat(result, is(6d));
	}

	/**
	* Test вычитания.
	*/
	@Test
	public void whenSubstructSevenToTwoThenFive() {

		final Calculate calc = new Calculate();
		calc.substruct(7, 2);

		final double result = calc.getResult();
		assertThat(result, is(5d));
	}

	/**
	* Test деления.
	*/
	@Test
	public void whenDivFourToTwoThenTwo() {

		final Calculate calc = new Calculate();
		calc.div(4, 2);

		final double result = calc.getResult();
		assertThat(result, is(2d));
	}

	/**
	* Test умножения.
	*/
	@Test
	public void whenMultipleFourToTwoThenEight() {

		final Calculate calc = new Calculate();
		calc.multiple(4, 2);

		final double result = calc.getResult();
		assertThat(result, is(8d));
	}
}
