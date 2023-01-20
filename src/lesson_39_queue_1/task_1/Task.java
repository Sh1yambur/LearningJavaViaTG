package lesson_39_queue_1.task_1;

public class Task {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        for (int i = 0; i < 10; i++) {
            list.add("{" + i + "}");
        }
        System.out.println(list);

        reverseList(list);
        System.out.println(list);

        removeElementsWithEvenHash(list);
        System.out.println(list);
    }

    @SuppressWarnings("unchecked")
    private static <T> void reverseList(CustomList<T> originList) {
        T[] array = (T[]) new Object[originList.size()];
        int count = 0;

        while (originList.size() != 0) {
            T element = originList.pollLast();
            count++;
            array[count - 1] = element;
        }

        for (int i = 0; i < count; i++) {
            originList.add(array[i]);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> void removeElementsWithEvenHash(CustomList<T> originList) {
        T[] array = (T[]) new Object[originList.size()];
        int count = 0;

        while (originList.size() != 0) {
            T element = originList.pollLast();

            if (element.hashCode() % 2 != 0) {
                count++;
                array[count - 1] = element;
            }
        }

        for (int i = count - 1; i >= 0; i--) {
            originList.add(array[i]);
        }
    }
}
