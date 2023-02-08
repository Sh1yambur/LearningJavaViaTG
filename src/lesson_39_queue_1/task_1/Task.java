package lesson_39_queue_1.task_1;

public class Task {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        for (int i = 0; i < 10; i++) {
            list.add("(" + i + ")");
        }
        System.out.println(list);

        reverseList(list);
        System.out.println(list);

        removeElementsWithEvenHash(list);
        System.out.println(list);
    }

    private static <T> void reverseList(CustomList<T> originList) {
        int start = 0;
        int end = originList.size() - 1;

        while(start < end){
            T first = originList.get(start);
            T last = originList.get(end);
            originList.set(start, last);
            originList.set(end, first);
            start++;
            end--;
        }
    }

    private static <T> void removeElementsWithEvenHash(CustomList<T> originList) {
        int size = originList.size();

        for (int i = 0; i < size; i++) {
            if(originList.get(i).hashCode() % 2 == 0){
                originList.remove(i);
                i--;
                size--;
            }
        }
    }
}
