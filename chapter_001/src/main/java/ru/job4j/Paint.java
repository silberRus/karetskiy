package ru.job4j;

/**
* Class псевдографики.
* @author karetskiy
* @since 05.01.2017
* @version 1
*/
public class Paint {

	/**
	* рисует пирамиду переданной высоты.
	* @param h - высота пирамиды
	* @return result – строку :
	*/
	public String piramid(int h) {

		String rn = System.getProperty("line.separator");
		StringBuilder result = new StringBuilder();

		for (int line = 1; line <= h; line++) {

			int probLeft 	= h - line;
			int probInside 	= line * 2 - 3;

			result.append(probels(probLeft));
			result.append("^");

			if (line > 1) {
				result.append(probels(probInside));
				result.append("^");
			}
			result.append(rn);
		}
		return result.toString();
	}

	/**
	* Создает строку длиной n пробелов.
	* @param number - сколько проблов в строке
	* @return result – возвращает строку с количеством пробелов:
	*/
	private String probels(int number) {

		StringBuilder spaceLine = new StringBuilder();

		for (int i = 0; i < number; i++) {
			spaceLine.append(" ");
			}
		return spaceLine.toString();
	}
}