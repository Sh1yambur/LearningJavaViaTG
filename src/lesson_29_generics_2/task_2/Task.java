package lesson_29_generics_2.task_2;

public class Task {
    public static void main(String[] args) {
        System.out.println(getInstance(3.14).getClass());
    }

    private static <T extends Number> CustomNumber<? extends Number> getInstance(T param) {
        return new CustomNumber<>(param);
    }
}
