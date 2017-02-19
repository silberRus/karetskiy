package ru.job4j.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Class обработки потоков.
 * @author karetskiy
 * @since 12.02.2017
 * @version 1
 */
public class stream {

    boolean isNumber(InputStream in) throws IOException {

        Scanner scanner = new Scanner(in);

        do {

            byte b = scanner.nextByte();

        }

        try {
            int num = in.read();
        } catch (


                );


        return true;
    }

}
