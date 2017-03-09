package ru.job4j.sortFile;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test класса сортировки файла.
 * @author Karetskiy
 * @version 4
 * @since 10.03.2017
 */
public class ServiceTest {

    /**
     * Проверим сортировку текстового файла по длинам строк
     * Создадим временный файл с неправильной сортировкой, отсортируем и проверим результат.
     */
    @Test
    public void sort() throws Exception {

        String strSoource =
                "Строка 1 длина 123456789" + System.lineSeparator() +
                        "Строка 2 длина 123" + System.lineSeparator() +
                        "Строка 3 длина 1234" + System.lineSeparator() +
                        "Строка 4 длина 123" + System.lineSeparator() +
                        "Строка 5 длина 123456" + System.lineSeparator();

        String expect   =
                "Строка 2 длина 123" + System.lineSeparator() +
                        "Строка 4 длина 123" + System.lineSeparator() +
                        "Строка 3 длина 1234" + System.lineSeparator() +
                        "Строка 5 длина 123456" + System.lineSeparator() +
                        "Строка 1 длина 123456789" + System.lineSeparator();

        File tempR = File.createTempFile("zad3_source",".txt");
        File tempS = File.createTempFile("zad3_dest",".txt");

        try (FileWriter writer = new FileWriter(tempR.getAbsolutePath(), false))
        {
            writer.write(strSoource);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String result = "";
        Service srv = new Service();
        srv.sort(tempR, tempS);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(tempS))) {

            String str = "";

            while ((str = bufferedReader.readLine()) != null) {
                result.concat(str).concat(System.lineSeparator());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(result, is(expect));
    }

}