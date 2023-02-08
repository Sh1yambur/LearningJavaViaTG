package lesson_39_queue_1.task_4;

/*
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */

import lesson_39_queue_1.task_3.DoublyLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> {
    private final DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public boolean offer(T value) {
        list.addLast(value);
        return list.getLast().equals(value);
    }

    public T peek() {
        try {
            return list.getFirst();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public T poll() {
        T element = peek();
        if (element != null) {
            list.remove(element);
        }

        return element;
    }

    @Override
    public String toString() {
        return list.toString().replace("<=>", "<-");
    }
}
