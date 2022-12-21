package lesson_33_files_2.task_1;

/*
 * Вариант 1: FileWriter;
 * Вариант 2: BufferedOutputStream;
 * Вариант 3: BufferedWriter.
 */

import java.io.*;

public class Task {
    private static final File FILE = new File("./resource/task_33/cars_catalog.dat");

    public static void main(String[] args) {
        //useFileWriter(makeMockCars());
        //useBufferedOutputStream(makeMockCars());
        useBufferedWriter(makeMockCars());
    }

    // #1
    private static void useFileWriter(Car[] cars) {
        try (FileWriter writer = new FileWriter(FILE)) {
            for (Car car : cars) {
                writer.append(makeString(car));
                writer.append(System.lineSeparator());
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // #2
    private static void useBufferedOutputStream(Car[] cars) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE))) {
            for (Car car : cars) {
                bos.write(makeString(car).getBytes());
                bos.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // #3
    private static void useBufferedWriter(Car[] cars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (Car car : cars) {
                writer.append(makeString(car));
                writer.append(System.lineSeparator());
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String makeString(Car car) {
        return "%s|%s|%d".formatted(car.brand(), car.model(), car.year());
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

record Car(String brand, String model, int year) {
}
