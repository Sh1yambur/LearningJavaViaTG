package lesson_28_generics_1.task_4;

/*
 * Реализовать параметризованный класс, хранящий и обрабатывающий стек.
 * Стек — структура данных, в котором каждый элемент хранит ссылку на следующий.
 * Работает по принципу LIFO (последний вошел — первый вышел).
 * Реализовать следующие методы:
 * Добавление элемента в стек;
 * Удаление элемента из стека. При удалении несуществующего элемента – исключение;
 * Получение глубины (количества элементов) стека;
 * Поиск по стеку, при отсутствии искомого значения – исключение;
 * Получение строкового эквивалента элементов стека, представленных в виде массива
 * ([строковое представление элемента1, ..., строковое представление элементаN]).
 */

public class Task {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        //System.out.println(list.find("two"));
        System.out.println(list.size());
        System.out.println(list);

        list.add("one");
        String twoAsObj = new String("two");
        list.add(twoAsObj);
        list.add("three");
        list.add("42");

        System.out.println(list.size());
        System.out.println(list);

        String twoStr = new String("two");
        //System.out.println(list.find(twoStr));

        list.delete(twoAsObj);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.find(twoAsObj));
        //list.delete("four");
    }
}
