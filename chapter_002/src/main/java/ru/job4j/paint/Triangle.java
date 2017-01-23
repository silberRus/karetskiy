package ru.job4j.paint;

/**
 * Class треугольника.
 * @author karetskiy
 * @since 23.01.2017
 * @version 1
 */
public class Triangle implements Shape {

    /**
     * Рисует треугольник выотой 3.
     * @return треуголник в псевдографике :
     */
    public String pic() {

        String rn = System.getProperty("line.separator");

        return  "Это треугольник:" + rn +
                "  ^" + rn +
                " / \\" + rn +
                "/___\\ ";
    }
}
