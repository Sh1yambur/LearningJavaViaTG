package lesson_28_generics_1.task_1;

/*
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */

public class Task {
    public static void main(String[] args) {
        CustomNumber<Byte> num1 = new CustomNumber<>((byte) 2);
        System.out.println(num1.pow(3));

        CustomNumber<Double> num2 = new CustomNumber<>(2.5);
        System.out.println(num2.pow(3));
    }
}
