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
		int back = size - 1;

		for (int front = 0; front < size / 2; front++, back--) {

			int buffer = array[front];

			array[front] = array[back];
			array[back] = buffer;
		}
		return array;
	}
}