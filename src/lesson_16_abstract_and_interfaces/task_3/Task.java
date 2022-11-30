package lesson_16_abstract_and_interfaces.task_3;

public class Task {
    public static void main(String[] args) {
        Soundable[] animals = {new Dog(), new Cat(), new Cow()};
        for (Soundable animal : animals) {
            System.out.println(animal.getSound());
        }
    }
}
