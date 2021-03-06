package ru.job4j.professions;

/**
* Class Класс точки.
* @author karetskiy
* @since 28.12.2016
* @version 1
*/
public class Point {

	/**
	* Координаты 2D точки.
	*/
	private double x, y;

	/**
	* Иницилизация класса.
	* @param x - значение по координате x
	* @param y - значение по координате y
	*/
	public Point(double x, double y) {

		this.x = x;
		this.y = y;
	}

	/**
	* Вычисление длины отрезка между текущей точкой и переданной.
	* @param point - точка до которой нужно вычислить расстояние
	* @return result – расстояние межде точками:
	*/
	public double distanceTo(Point point) {

		//calculate distance between two points

		return Math.sqrt(Math.abs(Math.pow(point.x - this.x, 2)) + Math.abs(Math.pow(point.y - this.y, 2)));
	}
}

