package lesson_39_queue_1.task_4;

/*
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */

import lesson_39_queue_1.task_3.DoublyLinkedList;

public class CustomQueue<T> {
    private final DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public void offer(T value) {
        list.addLast(value);
    }

    public T peek() {
        return list.getFirst();
    }

    public T poll() {
        T element = peek();
        list.remove(element);
        return element;
    }

    @Override
    public String toString() {
        return list.toString().replace("<=>", "<-");
    }
}
