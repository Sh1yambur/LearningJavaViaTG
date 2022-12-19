package lesson_32_files_1.task_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Task {
    private static final String PATH = "./resource/task_32/cars_catalog.dat";

    public static void main(String[] args) {
        writeCars(makeMockCars());
    }

    private static void writeCars(Car[] cars) {
        try (FileOutputStream out = new FileOutputStream(PATH)) {
            for (Car car : cars) {
                out.write(makeString(car).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
            System.out.println("Data was written to " + Paths.get(PATH).toAbsolutePath()); // log
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String makeString(Car car) {
        return "%s|%s|%d".formatted(
                car.getBrand(),
                car.getModel(),
                car.getYear()
        );
    }

    private static Car[] makeMockCars() {
        return new Car[]{
                new Car("Honda", "Accord", 2008),
                new Car("Toyota", "Camry", 2010),
                new Car("Ford", "F-150", 2020),
                new Car("Lada", "Kalina", 2015)
        };
    }
}
