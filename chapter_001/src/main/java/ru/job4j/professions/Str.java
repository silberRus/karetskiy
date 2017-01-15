package ru.job4j.professions;

import java.util.Arrays;

/**
* Class работы со строками.
* @author karetskiy
* @since 09.01.2017
* @version 1
*/
public class Str {

	/**
	* Проверяем вхождение строки.
	* @param origin - строка в которой ищем подстроку.
	* @param sub - подстрока которую ищем.
	* @return истина если подстрока входит в строку:
	*/
	public boolean contains(String origin, String sub) {

		char[] chOrigin = origin.toCharArray();
		char[] chSub = sub.toCharArray();
		int size = chSub.length;

		for (int ind = 0; ind < chOrigin.length - size; ind++) {

			if (Arrays.equals(Arrays.copyOfRange(chOrigin, ind, ind + size), chSub)) {
				return true;
			}
		}
		return false;
	}
}