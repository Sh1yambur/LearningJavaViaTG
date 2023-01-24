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

    public T get(int index) {
        return getNode(index).value;
    }

    private Node<T> getNode(int index) {
        int currentIndex = size - 1;

        Node<T> currentNode = top;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode;
            }
            currentNode = currentNode.next;
            currentIndex--;
        }

        throw new NoSuchElementException();
    }

    public void add(int index, T value) {
        Node<T> replacedNode = getNode(index);
        replacedNode.next = new Node<>(value, replacedNode.next);
        size++;
    }

    public void set(int index, T value) {
        getNode(index).value = value;
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

    public void remove(int index) {
        Node<T> removedNode = getNode(index);
        if (index == size - 1) {
            top = top.next;
        } else {
            getNode(index + 1).next = removedNode.next;
        }
        size--;
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
