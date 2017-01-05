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
public class PaintTest {

	/**
	* Рисуем пирамиду высотой 3.
	* правильный ответ:
	*				  ^
	*				 ^ ^
	*				^   ^
	*/
	@Test
	public void piramidaH3() {

		int h = 3;

		Paint paint = new Paint();
		String result = paint.piramid(h);
		final String area = new String("  ^\n ^ ^\n^   ^\n");

		assertThat(result, is(area));
	}
}