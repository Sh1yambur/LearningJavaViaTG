package lesson_60_thread.task_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static long sleepTime = 500L; // 2000ms
    static int count = 1;

    public static void main(String[] args) throws Exception {
        Thread secondThread = new Thread(() -> {
            while (count <= 10) {
                System.out.printf("(%02d) %s%n", count, LocalDateTime.now().format(formatter));
                count++;

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        secondThread.start();
    }
}
