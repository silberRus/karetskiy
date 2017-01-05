package ru.job4j;

/**
* Class массивов.
* @author karetskiy
* @since 05.01.2017
* @version 1
*/
public class Turn {

	/**
	* Переварачиваем массив.
	* @param array - массив который надо перевернуть
	* @return перевернутый массив:
	*/
	public int[] back(int[] array) {

		int size = array.length;

		for (int ind = 0; ind < size; ind++) {

			int buffer = array[ind];

			array[ind] 				= array[size - ind - 1];
			array[size - ind - 1] 	= buffer;
		}
		return array;
	}
}