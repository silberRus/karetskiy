package ru.job4j.professions;

/**
 * Class сравнений и хранения min max.
 * @author karetskiy
 * @since 11.01.2017
 * @version 4
 */
public class Cell {

	/**
	* Минимальное и максимальное числа.
	*/
    public int min, max;

    /**
     * Сравнивает два числа в двух массивах по одному индексу,
     * большое число записывает в max, а мальенкое в min.
     * @param arr1 - первый массив.
     * @param arr2 - второй массив.
     * @param ind - индекс массивов откуда брать значения
     * @return возвращает истина если оба массива
     * не вышли за границы диапозона своей длины:
     */
    public boolean compare(int[] arr1, int[] arr2, int ind) {

        if (ind >= arr1.length) {

            this.max = arr2[ind];
            this.min = 0;
            return false;

        } else if (ind >= arr2.length) {

            this.max = arr1[ind];
            this.min = 0;
            return false;

        } else {

            this.compare(arr1[ind], arr2[ind]);
            return true;
        }
    }

    /**
     * Сравнивает два числа,
     * большое число записывает в max
     * а мальенкое в min.
     * @param num1 - первое число.
     * @param num2 - второе число.
     */
    public void compare(int num1, int num2) {

        if (num1 > num2) {

            this.max = num1;
            this.min = num2;

        } else {

            this.max = num2;
            this.min = num1;
        }
    }
}
