package lesson_62_objects_methods.task_1;
// https://telegra.ph/Metody-Object-dlya-mnogopotochnosti-04-01

/*
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры, другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */

public class Main {
    public static void main(String[] args) {
        Message message = new Message();

        Thread readThread = new Thread(new Reader(message));
        Thread printThread = new Thread(new Printer(message));

        readThread.start();
        printThread.start();
    }
}
