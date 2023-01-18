package lesson_38_comparator.task_2;

/*
 * Используя классы-сущности из задачи к уроку 21 имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier.
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали).
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<Car> cars = getMockCars();

//        cars.sort(Comparator.naturalOrder());
//        cars.forEach(System.out::println);

        cars.sort(Comparator.reverseOrder());
        cars.forEach(System.out::println);
    }

    private static List<Car> getMockCars() {
        return new ArrayList<>(List.of(
                new Car("s462kf", 2005, "grey", true),
                new Car("d485sf", 2008, "blue", true),
                new Car("j512fh", 1996, "black", false),
                new Car("j512fh", 1990, "red", false),
                new Car("j512fh", 2000, "yellow", true),
                new Car("u689yu", 2020, "green", true)
        ));
    }
}
