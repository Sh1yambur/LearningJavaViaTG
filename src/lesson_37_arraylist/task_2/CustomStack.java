package lesson_37_arraylist.task_2;

import java.util.*;

public class CustomStack<T> implements Collection<T> {
    private Node<T> top;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T value) {
        if (top == null) {
            top = new Node<>(value);
        } else {
            top = new Node<>(value, top);
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (top.value.equals(o)) {
            top = top.next;
            size--;

            return true;
        }

        Node<T> current = top;
        while (current.next != null) {
            if (current.next.value.equals(o)) {
                current.next = current.next.next;
                size--;

                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = top;
        while (current != null) {
            if (Objects.equals(current.value, o)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node<T> current = top;
        for (int i = 0; i < array.length; i++) {
            array[i] = current.value;
            current = current.next;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        System.arraycopy(toArray(), 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c.toArray()) {
            if (!contains(obj)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

        for (Object obj : c) {
            add((T) obj);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

        for (Object obj : c) {
            remove(obj);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object element : toArray()) {
            if (!c.contains(element)) {
                remove(element);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" --> ");

        Node<T> current = top;
        while (current != null) {
            joiner.add(current.value.toString());
            current = current.next;
        }

        return "[%s]".formatted(joiner.toString());
    }

    private class Itr implements Iterator<T>{
        private int cursor;
        private int lastReturned = -1; // used into Removal methods

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int i = cursor;
            if(i >= size){
                throw new NoSuchElementException();
            }

            Object[] array = toArray();
            cursor = i + 1;
            lastReturned = i;

            return (T) array[i];
        }

        // TODO write code to Removal methods
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
