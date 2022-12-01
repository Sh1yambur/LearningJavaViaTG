package lesson_18_instanceof.task_1;

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

    // instanceof (in switch)
    private static void getSound(Animal animal) {
        switch (animal) {
            case Cat cat -> cat.meow();
            case Cow cow -> cow.moo();
            case Dog dog -> dog.woof();
            default -> System.out.println("unknown sound");
        }
    }

    // getClass() and .class
    /*private static void getSound(Animal animal) {
        if (animal.getClass() == Cat.class) {
            ((Cat) animal).meow();
        } else if (animal.getClass() == Cow.class) {
            ((Cow) animal).moo();
        } else if (animal.getClass() == Dog.class) {
            ((Dog) animal).woof();
        } else {
            System.out.println("unknown animal");
        }
    }*/
}