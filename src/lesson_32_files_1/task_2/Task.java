package lesson_32_files_1.task_2;

import java.io.FileInputStream;
import java.io.IOException;

public class Task {
    private static final String PATH = "./resource/task_32/cars_catalog.dat";

    public static void main(String[] args) {
        for (Car car : makeCarsArray(readFile())) {
            System.out.println(car);
        }
    }

    private static String[] readFile() {
        String result = "";
        try (FileInputStream in = new FileInputStream(PATH)) {
            result = new String(in.readAllBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result.trim().split(System.lineSeparator());
    }

    private static Car makeCarByString(String str) {
        String[] param = str.split("\\|");
        return new Car(param[0], param[1], Integer.parseInt(param[2]));
    }

    private static Car[] makeCarsArray(String[] strings) {
        Car[] cars = new Car[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = makeCarByString(strings[i]);
        }

        return cars;
    }
}
