package ru.job4j.professions;

/**
* Class профессии.
* @author karetskiy
* @since 17.01.2017
* @version 2
*/
public class Profession {

	/**
	 * Переменная для накапливания опыта профессии.
	 */
	private int experience = 0;

	/**
	 * Получаем опыт.
	 * @return опыт.
	 */
	public int getExperience() {

		return this.experience;
	}

	/**
	 * Увеличивает опыт профессии.
	 */
	public void addExperience() {

		this.experience++;
	}
}