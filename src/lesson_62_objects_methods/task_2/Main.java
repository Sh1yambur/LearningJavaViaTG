package lesson_62_objects_methods.task_2;
// https://telegra.ph/Metody-Object-dlya-mnogopotochnosti-04-01

import lesson_62_objects_methods.task_2.model.Store;
import lesson_62_objects_methods.task_2.service.BuyerService;
import lesson_62_objects_methods.task_2.service.SupplierService;
import lesson_62_objects_methods.task_2.utility.Logger;
import lesson_62_objects_methods.task_2.utility.ThreadKiller;

import java.util.Scanner;

/*
 * Реализуйте имитацию оптовой базы с тремя поставщиками и тремя покупателями.
 * Максимальное число хранимых товаров определите на свой вкус.
 * Покупатели должны выкупать случайно сгенерированное число товаров при каждом посещении.
 * Если товаров недостаточно – при следующем посещении они должны попытаться купить на 1 единицу товара меньше.
 * Если это число достигает нуля – должно быть сгенерировано новое число.
 * Если база опустела (на ней не осталось товаров) – покупатели должны прекратить ее посещение до новых поставок.
 *
 * Поставщики должны поставлять случайно сгенерированное число товаров при каждом посещении.
 * Если на базе не хватает места для всех товаров поставщика – он должен поставить максимально возможное количество,
 * остальную поставку отложить до следующего посещения.
 * Если число товаров для поставки достигло нуля – должно быть сгенерировано новое число.
 * Если база заполнилась на 100% - поставщики должны прекратить попытки поставок до момента,
 * пока заполняемость базы не достигнет 25%.
 *
 * Логируйте действия покупателей и поставщиков в консоли.
 * Программа должна завершиться при вводе пользователем «Finish» с клавиатуры.
 * Другие пользовательские вводы не предусмотрены.
 * Рекомендую ограничить максимальное значение у Покупателей меньшим лимитом, чем у Поставщиков.
 * В таком случае выполнение программы будет более наглядным.
 */

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Store STORE = new Store(100);
    private static final ThreadKiller KILLER = new ThreadKiller();

    public static void main(String[] args) {
        Logger.log(Thread.currentThread().getName(), "start");
        makeThreads(3, 3);
        waitStop();
        Logger.log(Thread.currentThread().getName(), "finish");
        exit();
    }

    private static void makeThreads(int suppliers, int buyers) {
        for (int i = 0; i < suppliers; i++) {
            new SupplierService(STORE, KILLER);
        }

        for (int i = 0; i < buyers; i++) {
            new BuyerService(STORE, KILLER);
        }
    }

    private static void waitStop() {
        String input = "";
        while (!input.equalsIgnoreCase("stop")) {
            System.out.print("<== ");
            input = SCANNER.nextLine();
        }
    }

    private static void exit() {
        SCANNER.close();
        KILLER.kill();
        Logger.close();
        System.exit(0);
    }
}
