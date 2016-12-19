package ru.job4j;

/**
* Class Класс калькулятор обучение, сложение, вычитание, умножение и деление.
* @author karetskiy
* @since 19.12.2016
* @version 2
*/
public class Calculate {

	/**
	* Память калькулятора.
	*/
	private double result;

	/**
	* Возвращает результат из памяти калькулятора.
	* @return result – реультат калькулятора:
	*/
	public double getResult() {
		return this.result;
	}

	/**
	* Вычисляет сумму двух чисел, и записывает результат
	* во внутреннюю переменную класса result.
	* @param first - первое число
	* @param second - второе число
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* Удаляет из первого числа второе, и записывает результат
	* во внутреннюю переменную класса result.
	* @param first - первое число
	* @param second - второе число
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
	}

	/**
	* делит второе число на первое, и записывает результат
	* во внутреннюю переменную класса result.
	* @param first - первое число
	* @param second - второе число
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	* умножает числа, и записывает результат
	* во внутреннюю переменную класса result.
	* @param first - первое число
	* @param second - второе число
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
}