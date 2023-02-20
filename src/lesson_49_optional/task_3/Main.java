package lesson_49_optional.task_3;

/*
 * Реализуйте абстрактный класс «Животное», содержащий абстрактный метод sound().
 * Также реализуйте трех наследников: кота, собаку и корову.
 * Реализуйте метод, выводящий в консоль сообщение вида
 * «Это %тип животного%, он (она) говорит %результат метода sound()%»
 * Использование условных конструкций (if-else, switch-case, тернарный оператор)
 * и хранение типа наследника в виде поля недопустимо.
 * Подсказка: используйте or().
 */

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Cow(), new Dog(), null};

        for (Animal animal : animals) {
            getAnimalSound(animal);
        }
    }

    private static void getAnimalSound(Animal animal) {
        String msg = "It is a %s, she says %s%n";

        Optional.ofNullable(animal)
                .filter(a -> Cat.class.equals(a.getClass()))
                .map(a -> "cat")
                .or(() -> Optional.ofNullable(animal)
                        .filter(a -> Cow.class.equals(a.getClass()))
                        .map(a -> "cow"))
                .or(() -> Optional.ofNullable(animal)
                        .filter(a -> Dog.class.equals(a.getClass()))
                        .map(a -> "dog"))
                .ifPresentOrElse(
                        v -> System.out.printf(msg, v, animal.sound()),
                        () -> System.out.println("Unknown animal"));
    }
}
