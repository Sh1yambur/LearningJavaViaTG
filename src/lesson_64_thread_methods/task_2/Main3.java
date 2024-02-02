package lesson_64_thread_methods.task_2;

import java.lang.invoke.MethodHandles;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// явное прерывание вспомогательного потока основным
public class Main3 {
    private static final int[][] ARRAY = new int[100][1_000_000];
    private static final long PERIOD = 100;

    public static void main(String[] args) {
        Thread timingThread = new Thread(Main3::printCurrentTime, "Timing thread");
        Thread fillingThread = new FillingThread(timingThread, ARRAY);

        timingThread.start();
        fillingThread.start();
    }

    private static void printCurrentTime() {
        System.out.printf("%s started%n", Thread.currentThread().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");
        long tmr = 0;

        while (!Thread.interrupted()) {
            if (System.currentTimeMillis() - tmr >= PERIOD) {
                System.out.println(LocalTime.now().format(formatter));
                tmr = System.currentTimeMillis();
            }
        }

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }
}

class FillingThread extends Thread {
    private final Thread timingThread;
    private final int[][] array;

    public FillingThread(Thread timingThread, int[][] array) {
        this.setName("Filling thread");
        this.timingThread = timingThread;
        this.array = array;
    }

    @Override
    public void run() {
        System.out.printf("%s started%n", Thread.currentThread().getName());

        Random random = new Random();

        for (int[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(0, 1000);
            }
        }

        timingThread.interrupt();

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }
}
