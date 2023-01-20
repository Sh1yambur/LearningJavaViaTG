package lesson_39_queue_1.task_1;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class CustomList<T> {
    private Node<T> top;
    private int size = 0;

    public void add(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public void remove(T target) {
        if (top.value.equals(target)) {
            top = top.next;
            size--;
            return;
        }

        Node<T> current = top;
        while (current.next != null) {
            if (current.next.value.equals(target)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }

        throw new NoSuchElementException();
    }

    public int size() {
        return size;
    }

    public T find(T target) {
        Node<T> current = top;

        while (current != null) {
            if (current.value.equals(target)) {
                return current.value;
            }
            current = current.next;
        }

        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" -> ");
        Node<T> current = top;
        while (current != null) {
            joiner.add(current.toString());
            current = current.next;
        }

        return "[%s]".formatted(joiner);
    }

    public T pollLast() {
        if (top == null) {
            throw new NoSuchElementException();
        }

        T result = top.value;
        top = top.next;
        size--;

        return result;
    }

    /*@SuppressWarnings("unchecked")
    public void reverse() {
        T[] array = (T[]) new Object[size];

        int index = size - 1;
        Node<T> current = top;
        while (current != null) {
            array[index] = current.value;
            index--;
            current = current.next;
        }

        index = 0;
        current = top;
        while (index < size) {
            current.value = array[index];
            current = current.next;
            index++;
        }
    }*/

    /*public void removeElementsWithEvenHash() {
        Node<T> removal = null;
        Node<T> current = top;

        while (current != null) {
            if (current.value.hashCode() % 2 == 0) {
                removal = current;
            }
            current = current.next;

            if (removal != null) {
                remove(removal.value);
                removal = null;
            }
        }
    }*/

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
