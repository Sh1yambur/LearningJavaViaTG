package lesson_47_method_reference.task_3;

public record Filter(String info, String prompt, Matcher<Car, String> matcher) {
}
