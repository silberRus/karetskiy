package ru.job4j;

/**
* Class профессии.
* @author karetskiy
* @since 14.01.2017
* @version 1
*/
public class Profession {

	/**
	 * Переменная для накапливания опыта профессии.
	 */
	private int experience = 0;

	/**
	 * Увеличивает опыт профессии.
	 */
	public void addExperience() {

		this.experience++;
	}
}