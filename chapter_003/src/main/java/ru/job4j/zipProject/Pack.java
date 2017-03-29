package ru.job4j.zipProject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class архивирования файлов.
 * @author karetskiy
 * @since 29.03.2017
 * @version 1
 */
public class Pack {

    /**
     * Архивируем указанную директорию.
     * @param dest путь к архивируемой папке.
     * @param ext массив расширений которые попадут в архив архивировать.
     * @param out имя архива которое нужно создать .
     */
    public static void toZip(String dest, String[] ext, String out) throws IOException {

        FilenameFilter filter = (dir, name) -> {

            for (String ex : ext) {
                if (name.endsWith(ex) || name.lastIndexOf('.') == -1){
                    return true;
                }
            }
            return false;
        };

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(out))){
            addEntry(new File(dest), zout, filter, dest.length() + File.separator.length());
            zout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Архивируем указанную директорию со всеми вложенными папками и фильтром.
     * @param dest путь или файл для архивации.
     * @param zout поток в который записываем архив.
     * @param filter фильтр проверки расширений файлов.
     * @param lastChar число символов котороее нужно пропустить в пути к файлу чтобы путь был относительный род. папки.
     */
    private static void addEntry(File dest, ZipOutputStream zout, FilenameFilter filter, int lastChar) throws IOException {

        File[] files = dest.listFiles(filter);

        for (File file: files) {
            if (file.isDirectory())
            {
                addEntry(file, zout, filter, lastChar);
            } else {
                String patch = file.getPath();
                int len = patch.length();
                zout.putNextEntry(new ZipEntry(String.copyValueOf(patch.toCharArray(), lastChar, len - lastChar)));

                FileInputStream stream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                stream.read(data);
                zout.write(data);

                zout.closeEntry();
            }
        }
    }

    /**
     * Консольный вход. При запуске с консоля нужно указать параметры.
     * @param args строка параметров для архивации.
     */
    public static void main(String[] args) throws IOException {

        Pack.Args arg =  new Pack.Args(args);
        if (!arg.isFull()) {
            System.out.println("нужно указать параметры: -d <путь к архиву> -e <расширения файлов через запятую> -o <путь имя созлаваемого архива>");
        } else {
            toZip(arg.dest, arg.ext, arg.out);
            System.out.println(String.format("Проект заархивирован %s", arg.out));
        }
    }

    /**
     * Класс контейнер для парсинга строки и хранения параметров переданных в консоле.
     */
    private static class Args {

        /**
         * Путь к архивируемому каталогу.
         */
        String dest = "";

        /**
         * Файл создаваемого архива.
         */
        String out = "";

        /**
         * Путь к архивируемому каталогу.
         */
        String[] ext = {};

        /**
         * Конструктор принимает строку и сразу ее парсит.
         * @param args строка параметров для парсинга.
         */
        public Args(String[] args) {

            for (int ind = 0; ind < args.length - 1; ind++) {
                if ("-d".equals(args[ind])) {
                    this.dest = args[++ind];
                } else if ("-o".equals(args[ind])) {
                    this.out = args[++ind];
                } else if ("-e".equals(args[ind])) {
                    this.ext = args[++ind].split(",");
                }
            }
        }

        /**
         * Проверяет заполненость всех параметов.
         * @return Истина если все параметры заполнены.
         */
        public boolean isFull() {
            return !"".equals(this.dest) && !"".equals(this.out) && this.ext.length != 0;
        }
    }
}
