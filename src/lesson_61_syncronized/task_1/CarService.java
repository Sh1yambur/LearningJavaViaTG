package lesson_61_syncronized.task_1;

import java.util.HashMap;
import java.util.Map;

public class CarService {
    private final HashMap<Integer, Car> carsBase = new HashMap<>();
    private int lastIndex = 1;

    public synchronized void add(Car car) {
        if (!carsBase.containsValue(car)) {
            carsBase.put(lastIndex, car);
            log("INFO", car + " was added by index " + lastIndex);
            lastIndex++;
        } else {
            log("ERR ", car + " already exist");
        }
    }

    public synchronized void remove(Car car) {
        if (carsBase.containsValue(car)) {
            int index = carsBase.entrySet().stream()
                    .filter(e -> e.getValue().equals(car))
                    .mapToInt(Map.Entry::getKey)
                    .findFirst()
                    .getAsInt();

            log("INFO", index + "." + carsBase.get(index) + " was removed");
            carsBase.remove(index);
        } else {
            log("ERR ", car + " not found");
        }
    }

    public synchronized void update(Car targetCar, Car newCar) {
        if (!carsBase.containsValue(targetCar)) {
            log("ERR ", targetCar + " not found");
        } else if (carsBase.containsValue(newCar)) {
            log("ERR ", newCar + " already exist");
        } else {
            int index = carsBase.entrySet().stream()
                    .filter(e -> e.getValue().equals(targetCar))
                    .mapToInt(Map.Entry::getKey)
                    .findFirst()
                    .getAsInt();

            log("INFO", index + "." + carsBase.get(index) + " was updated at " + newCar);
            carsBase.put(index, newCar);
        }
    }

    private void log(String type, String message) {
        String output = "(%s)[%s] %s".formatted(Thread.currentThread().getName(), type, message);
        System.out.println(output);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\tbase size: ");
        builder.append(carsBase.size());
        builder.append("\n");

        carsBase.forEach((key, value) -> {
            builder.append(key);
            builder.append(".");
            builder.append(value);
            builder.append("\n");
        });

        return builder.toString();
    }
}
