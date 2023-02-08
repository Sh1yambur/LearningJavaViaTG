package lesson_39_queue_1.task_3;

/*
 * Реализуйте двусвязный список.
 * Реализуйте метод, разворачивающий список.
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */

public class Task {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.addLast("(" + i + ")");
        }
        System.out.println(list);

        reverse(list);
        System.out.println(list);

        removeElementsWithEvenHash(list);
        System.out.println(list);
    }

    private static <T> void reverse(DoublyLinkedList<T> originList) {
        int index = 1;
        while (index < originList.size()) {
            T current = originList.get(index);
            originList.remove(current);
            originList.addFirst(current);
            index++;
        }
    }

    private static <T> void removeElementsWithEvenHash(DoublyLinkedList<T> originList) {
        int size = originList.size();
        int index = 0;
        while (index < size) {
            T current = originList.get(index);
            if (current.hashCode() % 2 == 0) {
                originList.remove(current);
                size--;
                index--;
            }
            index++;
        }
    }
}
