package lesson_64_thread_methods.task_2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// использование потока демона
public class Main1 {
    private static final int[][] ARRAY = new int[100][1_000_000];
    private static final long PERIOD = 100;

    public static void main(String[] args) {
        Thread timingThread = new Thread(Main1::printCurrentTime, "Timing thread");
        Thread fillingThread = new Thread(Main1::fillArray, "Filling thread");

        timingThread.setDaemon(true);
        timingThread.start();

        fillingThread.start();
    }

    private static void printCurrentTime() {
        System.out.printf("%s started%n", Thread.currentThread().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");
        long tmr = 0;

        while (true) {
            if (System.currentTimeMillis() - tmr >= PERIOD) {
                System.out.println(LocalTime.now().format(formatter));
                tmr = System.currentTimeMillis();
            }
        }

        //System.out.printf("%s finished%n", Thread.currentThread().getName());
    }

    private static void fillArray() {
        System.out.printf("%s started%n", Thread.currentThread().getName());

        Random random = new Random();

        for (int[] arr : ARRAY) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(0, 1000);
            }
        }

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }
}
