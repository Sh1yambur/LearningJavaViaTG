package lesson_39_queue_1.task_1;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class CustomList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null);
            last = first;
        } else {
            last.next = new Node<>(value, null);
            last = last.next;
        }
        size++;
    }

    public void add(int index, T value) {
        if (index == 0) {
            first = new Node<>(value, first);
            size++;
        } else if (index == size) {
            add(value);
        } else {
            Node<T> previous = getNode(index - 1);
            Node<T> replaced = getNode(index);
            previous.next = new Node<>(value, replaced);
            size++;
            last = getNode(size - 1);
        }
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return first.value;
        }
    }

    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        } else {
            return last.value;
        }
    }

    private Node<T> getNode(int index) {
        int currentIndex = 0;

        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }

        throw new NoSuchElementException();
    }

    public void set(int index, T value) {
        getNode(index).value = value;
    }

    public void remove(T target) {
        if (size > 0) {
            if (first.value.equals(target)) {
                first = first.next;
                size--;
                if (size == 0) {
                    last = null;
                }
                return;
            }

            Node<T> current = first;
            while (current.next != null) {
                if (current.next.value.equals(target)) {
                    current.next = current.next.next;
                    size--;
                    last = getNode(size - 1);
                    return;
                }
                current = current.next;
            }
        }

        throw new NoSuchElementException();
    }

    public void remove(int index) {
        Node<T> removedNode = getNode(index);
        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
            last = getNode(size - 2);
            last.next = null;
        } else {
            getNode(index - 1).next = removedNode.next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public T find(T target) {
        Node<T> current = first;

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
        Node<T> current = first;
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
