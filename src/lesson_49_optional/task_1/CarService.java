package lesson_49_optional.task_1;

import java.util.HashMap;
import java.util.Optional;

public class CarService {
    private final HashMap<String, Car> carsMap;

    public CarService(Car[] cars) {
        carsMap = new HashMap<>();

        for (Car car : cars) {
            if (car != null) {
                carsMap.put(car.getNumber(), car);
            }
        }
    }

    public Optional<Car> findCar(Car target) {
        return Optional.ofNullable(carsMap.get(target.getNumber()));
    }
}
