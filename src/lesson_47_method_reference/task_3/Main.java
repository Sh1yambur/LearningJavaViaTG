package lesson_47_method_reference.task_3;

/*
 * Реализуйте Задачу 3 из урока 46 (),
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис, если это не было сделано ранее.
 */

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final CarService CAR_SERVICE = new CarService(getMockCars());
    private static final FilterService FILTER_SERVICE = new FilterService();

    public static void main(String[] args) {
        System.out.println("\t===== Let's go find a car =====");
        loop();
        System.out.println("\t===== Good bye =====");
    }

    private static Car[] getMockCars() {
        Car car0 = new Car("Honda", "Civic", 2008, 56456456);
        Car car1 = new Car("Toyota", "Hilux", 2017, 248466145);
        Car car2 = new Car("Ford", "F-150", 2010, 44564361);
        Car car3 = new Car("Volkswagen", "Golf", 2000, 44187896);
        Car car4 = new Car("Chevrolet", "Impala", 1980, 56456456);

        return new Car[]{car0, car1, car2, car3, car4};
    }

    private static void loop() {
        boolean isExecuting = true;

        while (isExecuting) {
            printTokenInfo();
            String token = getInput(" token");

            if (token.equalsIgnoreCase("q")) {
                isExecuting = false;
                continue;
            }

            Filter filter = FILTER_SERVICE.getAll().get(token);
            if (filter == null) {
                System.out.println("Wrong token! Try again\n");
                continue;
            }

            printPromptInfo(token);
            String target = getInput("target");
            // some logic of validate correct input (e.g. add regex field to the Filter-class and comparing it)

            System.out.println("\t===== Found this =====");
            CAR_SERVICE.findCars(filter, target).forEach(car -> System.out.printf("%s%n", car));
            System.out.println("\t======================");
        }
    }

    private static String getInput(String msg) {
        System.out.printf("[%s] <== ", msg);
        return SC.nextLine();
    }

    private static void printPromptInfo(String token) {
        System.out.printf("Input %s as <%s>%n",
                FILTER_SERVICE.getAll().get(token).info(),
                FILTER_SERVICE.getAll().get(token).prompt()
        );
    }

    private static void printTokenInfo() {
        System.out.println("Input type of search as one of:");
        FILTER_SERVICE.getAll().forEach((t, f) -> System.out.printf("[%s] - %s%n", t, f.info()));
        System.out.println("or\n[q] - for quit search");
    }
}
