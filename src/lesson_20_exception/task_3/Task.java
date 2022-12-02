package lesson_20_exception.task_3;

public class Task {
    public static void main(String[] args) {
        Animal[] animals = getMockAnimalsArray();

        try {
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] == null) {
                    throw new ArrayValidationException("Not Animal object in index " + i);
                }
                getSound(animals[i]);
            }
        } catch (ArrayValidationException | UnknownAnimalException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Animal[] getMockAnimalsArray() {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        Animal animal = new Animal();

        return new Animal[]{dog, cat, cow, null, animal};
    }

    // instanceof (in switch)
    private static void getSound(Animal animal) throws UnknownAnimalException {


        switch (animal) {
            case Cat cat -> cat.meow();
            case Cow cow -> cow.moo();
            case Dog dog -> dog.woof();
            default -> throw new UnknownAnimalException("Unknown animal");
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