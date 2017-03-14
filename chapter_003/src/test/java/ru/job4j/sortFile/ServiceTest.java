package ru.job4j.sortFile;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
                "27 Строка 1 длина 123456789" + System.lineSeparator() +
                        "21 Строка 2 длина 123" + System.lineSeparator() +
                        "22 Строка 3 длина 1234" + System.lineSeparator() +
                        "21 Строка 4 длина 123" + System.lineSeparator() +
                        "24 Строка 5 длина 123456" + System.lineSeparator();

        String expect   =
                "21 Строка 2 длина 123" + System.lineSeparator() +
                        "21 Строка 4 длина 123" + System.lineSeparator() +
                        "22 Строка 3 длина 1234" + System.lineSeparator() +
                        "24 Строка 5 длина 123456" + System.lineSeparator() +
                        "27 Строка 1 длина 123456789" + System.lineSeparator();

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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempS)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                result += line + System.lineSeparator();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(result, is(expect));
    }

    /**
     * Проверим сортировку текстового файла по длинам строк
     * Создадим временный файл с неправильной сортировкой, отсортируем и проверим результат.
     */
    @Test
    public void sortFiles() throws Exception {

        String path = "D:\\temp\\111\\conf_m.txt";
        File outF = File.createTempFile(path + "out",".txt");

        Service srv = new Service();
        srv.sort(new File(path), outF);

        assertThat(outF.exists(), is(true));
    }
}