package ru.job4j;

/**
* Class сумм.
* @author karetskiy
* @since 05.01.2017
* @version 1
*/
public class Counter {

	/**
	* Возвращает сумму четных чисел.
	* @param start - первое число от которой считаем сумму
	* @param finish - последнее число от которой считаем сумму
	* @return result – сумму четных чисел:
	*/
	public int add(int start, int finish) {

	int sum = 0;
	for (int add = start; add <= finish; add++) {
		if (add % 2 == 0) {
				sum += add;
			}
		}
	return sum;
	}

	/**
	* Вычисляет факториал числа.
	* @param start - число факториал которого вычисляется
	* @return result – факториал переданного числа:
	*/
	public int factorial(int start) {

	int result = 1;
	for (int inc = 1; inc <= start; inc++) {
		result *= inc;
		}
	return result;
	}
}