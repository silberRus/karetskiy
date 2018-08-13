package ru.job4j.Threads;

/**
 * Class демонстрирущий проблему многопоточности.
 *
 * @author karetskiy
 * @version 1
 * @since 13.08.2018
 */
public class Trable{

    /**
     * Точка запуска программы.
     * При запуске запускаем два потока,
     * которые будут менять одну и туже переменную.
     * @param args строковые параметры.
     */
    public static void main(String args[]) {

        DataX dataX = new DataX();

        new Thread(new CountThread(dataX, "Thread1")).start();
        new Thread(new CountThread(dataX, "Thread2")).start();
    }

    /**
     * Вспомогателььный класс для хранения значения переменной.
     */
    static class DataX{

        /**
         * Переменная для изменений.
         */
        private int x = 0;

        /**
         * Получает значение переменной и увеличивает ее значение на 1.
         * @return значение переменной.
         */
        public int getX() {
            return x++;
        }
    }

    /**
     * Class потока.
     */
    static class CountThread implements Runnable{

        /**
         * Класс хранния переменной.
         */
        private DataX dataX;

        /**
         * Имя потока.
         */
        private String name;

        /**
         * Конструктор, при создании задаем имя и переменную.
         * @param x класс хранеия переменной.
         * @param name имя потока.
         */
        public CountThread(DataX x, String name){

            this.dataX = x;
            this.name = name;
        }

        /**
         * Точка запуска потока.
         */
        public void run(){

            for (int i = 1; i < 10; i++){

                System.out.printf("%s %d \n", name, dataX.getX());

                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }
}