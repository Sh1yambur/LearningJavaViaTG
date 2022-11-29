package lesson_17_enum.task_2;

public class Task {
    public static void main(String[] args) {
        for (Animal animal : Animal.values()) {
            animal.say();
        }
    }
}


