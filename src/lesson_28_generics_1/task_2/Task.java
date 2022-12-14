package lesson_28_generics_1.task_2;

/*
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */

public class Task {
    public static void main(String[] args) {
        CustomType<String> type1 = new CustomType<>("");
        System.out.println(type1.isNull());

        CustomType<Integer> type2 = new CustomType<>(null);
        System.out.println(type2.isNull());

        CustomType<Object> type3 = new CustomType<>(new Object());
        System.out.println(type3.isNull());
    }
}
