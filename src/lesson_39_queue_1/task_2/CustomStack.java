package lesson_39_queue_1.task_2;

/*
 * Реализуйте структуру данных стек.
 * Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */

import lesson_39_queue_1.task_1.CustomList;

import java.util.StringJoiner;

public class CustomStack<T> {
    private final CustomList<T> list = new CustomList<>();

    public void push(T value) {
        list.add(value);
    }

    public T peek() {
        return list.getLast();
    }

    public T pop() {
        T result = peek();
        list.remove(result);

        return result;
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int search(T target) {
        int index = 1;
        while (index <= list.size()) {
            if (list.get(list.size() - index).equals(target)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ");

        int index = list.size() - 1;
        while (index >= 0) {
            joiner.add(list.get(index).toString());
            index--;
        }

        return "[%s]".formatted(joiner);
    }
}
