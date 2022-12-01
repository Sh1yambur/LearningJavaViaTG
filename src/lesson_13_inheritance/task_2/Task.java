package lesson_13_inheritance.task_2;

public class Task {
    public static void main(String[] args) {
        for (Animal animal : getMockAnimalsArray()) {
            getSound(animal);
        }
    }

    private static Animal[] getMockAnimalsArray() {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        Animal animal = new Animal();

        return new Animal[]{dog, cat, cow, animal};
    }

    // invoke original sound method of specific animal type
    private static void getSound(Animal animal) {
        switch (animal.getType()) {
            case "Dog" -> ((Dog) animal).woof();
            case "Cat" -> ((Cat) animal).meow();
            case "Cow" -> ((Cow) animal).moo();
            default -> System.out.println("unknown animal");
        }
    }
}