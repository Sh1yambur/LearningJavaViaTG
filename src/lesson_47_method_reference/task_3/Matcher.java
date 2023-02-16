package lesson_47_method_reference.task_3;

@FunctionalInterface
public interface Matcher<T, E> {
    boolean test(T t, E e);
}
