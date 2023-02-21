package lesson_49_optional.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CarService {
    private final Map<CarIdentifier, Car> cars = new HashMap<>();

    public CarService(Car[] cars) {
        for (Car car : cars) {
            this.cars.put(car.getIdentifier(), car);
        }
    }

    public Optional<Car> findCar(CarIdentifier identifier) {
        return Optional.ofNullable(cars.get(identifier));
    }

    public Optional<Residence> findCarOwnerFirstChildAddress(CarIdentifier carId) {
        return findCar(carId)
                .filter(car -> car.getIdentifier().getYear() <= 2021)
                .map(Car::getOwner)
                .filter(person -> !person.getProfession().equals("police officer"))
                .map(person -> person.getChildren()[0])
                .filter(child -> !child.getProfession().equals("police officer"))
                .map(Person::getResidence)
                .filter(residence -> !residence.address().contains("Rublev's highway"));
    }
}
