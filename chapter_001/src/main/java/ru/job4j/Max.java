package ru.job4j;

/**
* Class Макимумов.
* @author karetskiy
* @since 04.01.2017
* @version 1
*/
public class Max {

	/**
	* Возвращает максимальное число.
	* @param first - первое число
	* @param second - второе число
	* @return result – максимальное число:
	*/
	public int max(int first, int second) {

		return first > second ? first : second;
	}

	/**
	* Возвращает максимальное число.
	* @param first 	- первое число
	* @param second - второе число
	* @param third 	- третье число
	* @return result – максимальное число:
	*/
	public int max(int first, int second, int third) {

		return max(max(first, second), third);
	}
}