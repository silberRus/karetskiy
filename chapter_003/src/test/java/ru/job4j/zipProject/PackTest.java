package ru.job4j.zipProject;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test класса архивирования.
 * @author Karetskiy
 * @version 1
 * @since 29.03.2017
 */
public class PackTest {

    /**
     * Проверим создание файла архива.
     * Явно пропишем существующую папку к архиву.
     * Если архив появится, значит ок.
     */
    @Test
    public void toZip() throws Exception {

        String patch = "E:\\java\\projects\\karetskiy\\chapter_003";
        String outS = String.format("%s\\testZip.zip", patch);

        String[] args = {"-d", patch, "-e", "java,xml", "-o", outS};
        Pack.main(args);

        File fOut = new File(outS);
        assertThat(fOut.exists(), is(true));
    }
}