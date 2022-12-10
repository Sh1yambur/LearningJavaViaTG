package lesson_24_nested_classes.task_2_static_nested;

public class Task {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal.Cat(),
                new Animal.Cow(),
                new Animal.Dog()
        };

        for (Animal animal : animals) {
            animal.say();
        }
    }
}
