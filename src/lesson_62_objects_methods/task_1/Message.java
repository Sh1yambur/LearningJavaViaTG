package lesson_62_objects_methods.task_1;

import java.util.Scanner;

public class Message {
    private final Scanner scanner = new Scanner(System.in);
    private String text;
    private boolean isReading = false;
    private boolean isActive = true;

    public boolean isActive() {
        return isActive;
    }

    public synchronized void read() {
        while (isReading) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isReading = true;

        System.out.print(Thread.currentThread().getName() + " <== ");
        text = scanner.nextLine();

        if (text.equalsIgnoreCase("finish")) {
            isActive = false;
        }

        notifyAll();
    }

    public synchronized void print() {
        while (!isReading) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isReading = false;

        if (isActive) {
            System.out.println(Thread.currentThread().getName() + " ==> " + text);
        } else {
            System.out.println("\texit");
        }

        notifyAll();
    }
}
