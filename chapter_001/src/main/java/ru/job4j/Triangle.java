package ru.job4j;

/**
* Class Класс треугольника.
* @author karetskiy
* @since 30.12.2016
* @version 2
*/
public class Triangle {

	/**
	* Вершины треугольника.
	*/
	private Point a, b, c;

	/**
	* Иницилизация класса.
	* @param a - вершина треугльника a
	* @param b - вершина треугльника b
	* @param c - вершина треугльника c
	*/
	public Triangle(Point a, Point b, Point c) {

		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Вычисляет площадь треугольника.
	* @return result – площадь треугольника:
	*/
	public double area() {

		//calculate the triangle area

		double ab = this.a.distanceTo(this.b);
		double bc = this.b.distanceTo(this.c);
		double ca = this.c.distanceTo(this.a);

		double p = (ab + bc + ca) / 2;

		return ab < bc + ca && bc < ab + ca && ca < ab + bc ? Math.sqrt(p * (p - ab) * (p - bc) * (p - ca)) : 0;
	}
}