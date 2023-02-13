package lesson_43_map.task_2;

import java.util.HashMap;

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

    public Car findCar(Car target){
        return carsMap.get(target.getNumber());
    }
}
