package lesson_32_files_1.task_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringJoiner;

public class CarRepository {
    private final String path;
    private Car[] allCars;

    public CarRepository(String path) {
        this.path = path;
        allCars = getCarsFromFile(readFile());
    }

    public void add(Car car) {
        if (getCarIndex(car) == -1) {
            Car[] temp = allCars;
            allCars = Arrays.copyOf(temp, temp.length + 1);
            allCars[temp.length] = car;
        } else {
            System.out.println("Car already exist");
        }
        writeFile();
    }

    public void update(Car car, String brand, String model, int year) {
        int index = getCarIndex(car);
        if (index != -1) {
            if (brand != null) {
                allCars[index].setBrand(brand);
            }
            if (model != null) {
                allCars[index].setModel(model);
            }
            if (year != 0) {
                allCars[index].setYear(year);
            }
            writeFile();
        } else {
            System.out.println("Car not found");
        }
    }

    public void delete(Car car) {
        int index = getCarIndex(car);
        if (index != -1) {
            allCars[index] = null;
            Car[] tmp = allCars;
            allCars = new Car[tmp.length - 1];

            int j = 0;
            for (Car value : tmp) {
                if (value != null) {
                    allCars[j] = value;
                    j++;
                }
            }

            writeFile();
        } else {
            System.out.println("Car not found");
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Car car : allCars) {
            joiner.add(car.toString());
        }

        return joiner.toString();
    }

    // ==========================

    private int getCarIndex(Car anotherCar) {
        for (int i = 0; i < allCars.length; i++) {
            if (allCars[i].equals(anotherCar)) {
                return i;
            }
        }

        return -1;
    }

    private String[] readFile() {
        String result = "";
        try (FileInputStream in = new FileInputStream(path)) {
            result = new String(in.readAllBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (result.isBlank()) {
            return new String[0];
        }

        return result.trim().split(System.lineSeparator());
    }

    private Car makeCarByString(String str) {
        String[] param = str.split("\\|");

        return new Car(param[0], param[1], Integer.parseInt(param[2]));
    }

    private Car[] getCarsFromFile(String[] strings) {
        Car[] cars = new Car[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = makeCarByString(strings[i]);
        }

        return cars;
    }

    private void writeFile() {
        try (FileOutputStream out = new FileOutputStream(path)) {
            for (Car car : allCars) {
                out.write(makeString(car).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
            //System.out.println("Data was written to " + Paths.get(path).toAbsolutePath()); // log
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String makeString(Car car) {
        return "%s|%s|%d".formatted(
                car.getBrand(),
                car.getModel(),
                car.getYear()
        );
    }
}
