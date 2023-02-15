package lesson_47_method_reference.task_2;

/*
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль (System.out.println()) в собственный статический метод.
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List.of("One", "Two", "Three").forEach(Main::print);
    }

    private static void print(String msg){
        System.out.printf("%s ", msg);
    }
}
