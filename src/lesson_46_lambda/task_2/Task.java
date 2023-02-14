package lesson_46_lambda.task_2;

import java.util.List;

public class Task {
    public static void main(String[] args) {
        Soundable[] animals = {new Dog(), new Cat(), new Cow()};

        List.of(animals).forEach(animal -> System.out.println(animal.getSound()));
    }
}
