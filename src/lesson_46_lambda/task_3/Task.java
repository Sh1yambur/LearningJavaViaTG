package lesson_46_lambda.task_3;

/*
 * Реализуйте Задачу из урока 21, с использованием списка (или другой коллекции на ваш выбор).
 *
 * Дайте возможность искать машины по гибкому фильтру – возвращайте коллекцию машин,
 * подходящих под конкретный фильтр (можете расширить на свой вкус):
 *
 * Номер совпадает с введенным пользователем;
 * Номер содержит подстроку, указанную пользователем;
 * Цвет совпадает с указанным пользователем;
 * Год выпуска машины находится в диапазоне, указанном пользователем.
 *
 * При этом CarService должен содержать лишь один публичный метод поиска.
 * Можете использовать Predicate или собственный функциональный интерфейс.
 * Также реализуйте интерактивное меню в рамках консоли, позволяющее производить несколько поисков в рамках одного запуска программы.
 * Предусмотрите возможность завершения программы с помощью пользовательского ввода.
 */

import java.util.List;
import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);
    private static final CarService service = new CarService(getMockCars());

    public static void main(String[] args) {
        while (true) {
            System.out.println("Input search type as\n" +
                    "n - number of car,\n" +
                    "s - substring in car number,\n" +
                    "b - brand of car,\n" + // Color from task description replaced by Brand
                    "y - year of produced (begin-end),\n" +
                    "q - quit.\n" +
                    "Next line input find data.");

            String inputType = getInput("type");

            if (inputType.equals("q")) {
                System.out.println("Good bye");
                return;
            }

            String inputData = getInput("data");
            getFoundCars(inputType, inputData).forEach(car -> System.out.printf("==> %s%n", car));
            System.out.println("\t\t****");
        }
    }

    private static Car[] getMockCars() {
        Car car0 = new Car("Honda", "Civic", 2008, 56456456);
        Car car1 = new Car("Toyota", "Hilux", 2017, 248466145);
        Car car2 = new Car("Ford", "F-150", 2010, 44564361);
        Car car3 = new Car("Volkswagen", "Golf", 2000, 44187896);
        Car car4 = new Car("Chevrolet", "Impala", 1980, 56456456);

        return new Car[]{car0, car1, car2, car3, car4};
    }

    private static String getInput(String msg) {
        System.out.printf("[%s] <== ", msg);
        return SC.nextLine();
    }

    private static List<Car> getFoundCars(String type, String data) {
        return switch (type) {
            case "n" -> service.findCars(car -> car.getSerialNumber() == Integer.parseInt(data));
            case "s" -> service.findCars(car -> String.valueOf(car.getSerialNumber()).contains(String.valueOf(data)));
            case "b" -> service.findCars(car -> car.getBrand().equalsIgnoreCase(data));
            case "y" -> service.findCars(car -> {
                int[] years = foundYears(data);
                return car.getYearOfProduced() >= years[0] && car.getYearOfProduced() <= years[1];
            });
            default -> List.of();
        };
    }

    private static int[] foundYears(String input) {
        String[] str = input.split("-");
        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
}
