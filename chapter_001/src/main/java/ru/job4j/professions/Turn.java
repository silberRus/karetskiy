package ru.job4j.professions;

import java.util.Arrays;

/**
* Class массивов.
* @author karetskiy
* @since 11.01.2017
* @version 5
*/
public class Turn {

	/**
	 * Объединяем два сортированых массива в третий общий
	 * и сразу сортируем его за 1 проход.
	 * @param array1 - 1 сортиованный массив.
	 * @param array2 - 2 сортиованный массив.
	 * @return объединенный сортированный массив:
	 */
	public int[] unionAndSort(int[] array1, int[] array2) {

		Cell value = new Cell();
		Cell size = new Cell();
		size.compare(array1.length, array2.length);

		int[] newArray = new int[array1.length + array2.length];

		for (int ind = 0; ind < size.max; ind++) {

			if (value.compare(array1, array2, ind)) {

				newArray[ind * 2] 		= value.min;
				newArray[ind * 2 + 1] 	= value.max;

			} else {
				newArray[size.min * 2 + ind - size.min] = value.max;
			}
		}
		return newArray;
	}

	/**
	* Убираем дубликаты из массива.
	* @param array - массив в котором надо убрать дуюликаты.
	* @return массив без дубликатов:
	*/
	public String[] removeDublicates(String[] array) {

		String[] newArray = new String[array.length];
		int ind = 0;

		for (String value: array) {
			if (!valuePresent(newArray, value)) {
				newArray[ind] = value;
				ind++;
			}
		}
		return Arrays.copyOf(newArray, ind);
	}

	/**
	* Поварачиваем квадратный массив на 90 градусов.
	* @param array - 2D массив который надо повернуть
	* @return отсортированный массив:
	*/
	public int[][] rotate90R(int[][] array) {

		int size = array[0].length;
		int[][] newArray = new int[size][size];

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {

				newArray[x][y] = array[x][size - y - 1];
			}
		}
		return newArray;
	}

	/**
	* Сортируем массив методом пузырька.
	* @param array - массив который надо отсортировать
	* @return отсортированный массив:
	*/
	public int[] getSorting(int[] array) {

		boolean sorting;
		int size = array.length;

		do {
			sorting = true;
			for (int ind = 1; ind < size; ind++) {

				if (changeIfFirstLarge(array, ind - 1, ind)) {
					sorting = false;
				}
			}
		} while (!sorting);
		return array;
	}

	/**
	* @version 2
	* Переварачиваем массив.
	* @param array - массив который надо перевернуть
	* @return перевернутый массив:
	*/
	public int[] back(int[] array) {

		int size = array.length;
		int back = size - 1;

		for (int front = 0; front < size / 2; front++, back--) {
			change(array, front, back);
		}
		return array;
	}

	/**
	* Меняет значения ячеек массива.
	* @param array - массив значения в котором нужно перевернуть
	* @param first - индекс первой ячейки
	* @param second - индекс второй ячейки
	*/
	private void change(int[] array, int first, int second) {

		int buffer = array[first];

		array[first] = array[second];
		array[second] = buffer;
	}

	/**
	* Меняет значения ячеек массива если значение первого больше второго.
	* @param array - массив значения в котором нужно поменять.
	* @param first - индекс первой ячейки
	* @param second - индекс второй ячейки
	* @return истина если были изменены значения ячеек:
	*/
	private boolean changeIfFirstLarge(int[] array, int first, int second) {

		if (array[first] > array[second]) {
			change(array, first, second);
			return true;
		} else {
			return false;
		}
	}

	/**
	* Проверяет есть или нет значение в массие.
	* @param array - массив
	* @param value - значение которое проверяется в массиве
	* @return истина если значение есть:
	*/
	private boolean valuePresent(String[] array, String value) {

		for (String cell: array) {
			if (cell != null && cell.equals(value)) {
				return true;
			}
		}
		return false;
	}
}