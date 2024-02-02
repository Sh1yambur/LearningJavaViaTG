package lesson_64_thread_methods.task_2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// использование жизненного цикла потока и завершение вспомогательного потока после завершения основного
public class Main2 {
    private static final int[][] ARRAY = new int[100][1_000_000];
    private static final long PERIOD = 100;

    public static void main(String[] args) {
        Thread fillingThread = new Thread(Main2::fillArray, "Filling thread");
        Thread timingThread = new TimingThread(PERIOD, fillingThread);

        timingThread.start();
        fillingThread.start();
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

class TimingThread extends Thread {
    private final Thread observedThread;
    private final long period;

    public TimingThread(long period, Thread observedThread) {
        this.setName("Timing thread");
        this.observedThread = observedThread;
        this.period = period;
    }

    @Override
    public void run() {
        System.out.printf("%s started%n", Thread.currentThread().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");
        long tmr = 0;

        while (observedThread.isAlive()) {
            if (System.currentTimeMillis() - tmr >= period) {
                System.out.println(LocalTime.now().format(formatter));
                tmr = System.currentTimeMillis();
            }
        }

        System.out.printf("%s finished%n", Thread.currentThread().getName());
    }
}
