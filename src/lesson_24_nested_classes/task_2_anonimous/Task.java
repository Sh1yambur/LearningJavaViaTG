package lesson_24_nested_classes.task_2_anonimous;

public class Task {
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal() {
                    @Override
                    public void say() {
                        System.out.println("meow");
                    }
                },
                new Animal() {
                    @Override
                    public void say() {
                        System.out.println("moo");
                    }
                },
                new Animal() {
                    @Override
                    public void say() {
                        System.out.println("woof");
                    }
                }
        };

        for (Animal animal : animals) {
            animal.say();
        }
    }
}
