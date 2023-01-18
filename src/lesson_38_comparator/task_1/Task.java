package lesson_38_comparator.task_1;

/*
 * Используя классы-сущности из задачи к уроку 21 реализуйте сортировку машин по:
 * Номеру;
 * Цвету;
 * Году;
 * Номеру и году.
 *
 * Используйте список для хранения и сортировки коллекции машин.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        Comparator<Car> numberComp = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getIdentifier().getNumber().compareTo(car2.getIdentifier().getNumber());
            }
        };

        Comparator<Car> colorComp = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getColor().compareTo(car2.getColor());
            }
        };

        Comparator<Car> yearComp = new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getIdentifier().getYear() - car2.getIdentifier().getYear();
            }
        };

//        List<Car> numberSortList = getMockCars();
//        numberSortList.sort(numberComp);
//        numberSortList.forEach(System.out::println);
//
//        List<Car> colorSortList = getMockCars();
//        colorSortList.sort(colorComp);
//        colorSortList.forEach(System.out::println);
//
//        List<Car> yearSortList = getMockCars();
//        yearSortList.sort(yearComp);
//        yearSortList.forEach(System.out::println);

        List<Car> numberYearSortList = getMockCars();
        numberYearSortList.sort(numberComp.thenComparing(yearComp));
        numberYearSortList.forEach(System.out::println);
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
