package ru.job4j.professions;

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
	* Проверяем возможность существоавания треуголника по длинам сторон.
	* @param ab - длина 1
	* @param bc - длина 2
	* @param ca - длина 3
	* @return возможность существования треугольника:
	*/
	private boolean exist(double ab, double bc, double ca) {

		return ab < bc + ca && bc < ab + ca && ca < ab + bc;
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

		if (exist(ab, bc, ca)) {
			return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
		} else {
			return 0;
		}
	}
}