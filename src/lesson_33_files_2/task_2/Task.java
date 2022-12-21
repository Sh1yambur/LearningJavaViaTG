package lesson_33_files_2.task_2;

/*
 * Вариант 1: FileReader;
 * Вариант 2: BufferedInputStream;
 * Вариант 3: BufferedReader.
 */

import java.io.*;
import java.util.StringJoiner;

public class Task {
    private static final File FILE = new File("./resource/task_33/cars_catalog.dat");

    public static void main(String[] args) {
        //Car[] cars = useFileReader();
        //Car[] cars = useBufferedInputStream();
        Car[] cars = useBufferedReader();

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // #1
    private static Car[] useFileReader() {
        StringBuilder builder = new StringBuilder();

        try (FileReader reader = new FileReader(FILE)) {
            int b;
            while ((b = reader.read()) != -1) {
                builder.append((char) b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return makeCarsArray(builder.toString().split(System.lineSeparator()));
    }

    // #2
    private static Car[] useBufferedInputStream() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE))) {
            return makeCarsArray(new String(bis.readAllBytes()).split(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // #3
    private static Car[] useBufferedReader() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String str;
            while ((str = reader.readLine()) != null) {
                joiner.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return makeCarsArray(joiner.toString().split(System.lineSeparator()));
    }

    private static Car[] makeCarsArray(String[] strings) {
        Car[] cars = new Car[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = makeCarByString(strings[i]);
        }

        return cars;
    }

    private static Car makeCarByString(String str) {
        String[] param = str.split("\\|");
        return new Car(param[0], param[1], Integer.parseInt(param[2]));
    }
}

record Car(String brand, String model, int year) {
}
