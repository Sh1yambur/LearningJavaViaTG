package lesson_64_thread_methods.task_2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// volatile
public class Main {
    private static final int[][] ARRAY = new int[100][1_000_000];
    private static final long PERIOD = 100;

    private static volatile boolean isCompute;

    public static void main(String[] args) throws InterruptedException {
        Thread timingThread = new Thread(Main::printCurrentTime, "Timing thread");
        Thread fillingThread = new Thread(Main::fillArray, "Filling thread");

        timingThread.start();
        fillingThread.start();
    }

    private static void printMostCommonNumber() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int[] arr : ARRAY) {
            long common = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();

            joiner.add(String.valueOf(common));
        }
        System.out.println(joiner);
    }

    private static void printCurrentTime() {
        System.out.printf("%s started%n", Thread.currentThread().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");
        long tmr = 0;

        while (isCompute) {
            if (System.currentTimeMillis() - tmr >= PERIOD) {
                System.out.println(LocalTime.now().format(formatter));
                tmr = System.currentTimeMillis();
            }
        }

        /*while (isCompute) {
            System.out.println(LocalTime.now().format(formatter));
            try {
                Thread.sleep(PERIOD);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }

    private static void fillArray() {
        System.out.printf("%s started%n", Thread.currentThread().getName());

        Random random = new Random();
        isCompute = true;

        for (int[] arr : ARRAY) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(0, 1000);
            }
        }

        isCompute = false;

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }
}
