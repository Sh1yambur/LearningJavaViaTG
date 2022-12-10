package lesson_25_nested_classes.task_2_inner;

public class Task {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal().new Cat(),
                new Animal().new Cow(),
                new Animal().new Dog()
        };

        for (Animal animal : animals) {
            animal.say();
        }
    }
}
