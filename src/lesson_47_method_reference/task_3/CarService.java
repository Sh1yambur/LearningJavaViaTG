package lesson_47_method_reference.task_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarService {
    private final HashSet<Car> carsCollection = new HashSet<>();

    public CarService(Car... cars) {
        List.of(cars)
                .forEach(this::addCar);
    }

    public void addCar(Car car) {
        carsCollection.add(car);
    }

    public List<Car> findCars(Filter filter, String target) {
        List<Car> foundCarsList = new ArrayList<>();

        carsCollection.forEach(car -> {
            if (filter.matcher().test(car, target)) {
                foundCarsList.add(car);
            }
        });

        return foundCarsList;
    }
}
