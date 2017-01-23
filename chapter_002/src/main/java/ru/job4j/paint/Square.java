package ru.job4j.paint;

/**
 * Class треугольника.
 * @author karetskiy
 * @since 23.01.2017
 * @version 1
 */
public class Square implements Shape {

    /**
     * Рисует квадрат выотой 3x3.
     * @return квадрат в псевдографике :
     */
    public String pic() {

        String rn = System.getProperty("line.separator");

        return  "Квадрат: " + rn +
                "---" + rn +
                "| |" + rn +
                "---";
    }
}
