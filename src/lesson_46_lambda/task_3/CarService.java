package lesson_46_lambda.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final HashMap<Integer, Car> carsCollection = new HashMap<>();

    public CarService(Car... cars) {
        List.of(cars).forEach(this::addCar);
    }

    public void addCar(Car car) {
        carsCollection.put(car.getHashCode(), car);
    }

    public List<Car> findCars(Predicate<Car> predicate) {
        List<Car> foundCarsList = new ArrayList<>();

        carsCollection.forEach((id, car) -> {
            if (predicate.test(car)) {
                foundCarsList.add(car);
            }
        });

        return foundCarsList;
    }
}
