package lesson_39_queue_1.task_3;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DoublyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    void addFirst(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
            last = first;
        } else {
            Node<T> added = new Node<>(value, null, first);
            first.prev = added;
            first = added;
        }
        size++;
    }

    void addLast(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
            last = first;
        } else {
            Node<T> added = new Node<>(value, last, null);
            last.next = added;
            last = added;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        if (first.value == null) {
            throw new NoSuchElementException();
        } else {
            return first.value;
        }
    }

    public T getLast() {
        if (last.value == null) {
            throw new NoSuchElementException();
        } else {
            return last.value;
        }
    }

    public T get(int index) {
        int count = 0;

        Node<T> current = first;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            current = current.next;
            count++;
        }

        throw new NoSuchElementException();
    }

    void remove(T target) {
        if (first.value.equals(target)) {
            if (first.next != null) {
                first = first.next;
                first.prev = null;
            } else {
                first = null;
                last = null;
            }
            size--;
            return;

        } else if (last.value.equals(target)) {
            last = last.prev;
            last.next = null;
            size--;
            return;

        } else {
            Node<T> current = first;
            while (current != null) {
                if (current.value.equals(target)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return;
                }
                current = current.next;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" <=> ");

        Node<T> current = first;
        while (current != null) {
            joiner.add(current.value.toString());
            current = current.next;
        }

        return "[%s]".formatted(joiner);
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
