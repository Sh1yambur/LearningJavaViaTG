package lesson_47_method_reference.task_3;

import java.util.Scanner;

public class Menu {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FilterService FILTER_SERVICE = new FilterService();

    private static CarService carService;

    public static void setCarService(CarService service) {
        carService = service;
    }

    public static void execute() {
        if (carService == null) {
            throw new RuntimeException("Service in menu is not set");
        }

        System.out.println("\t===== Let's go find a car =====");

        while (true) {
            printTokensInfo();
            String token = getInput(" token");

            if (token.equalsIgnoreCase("q")) {
                System.out.println("\t===== Good bye =====");
                SCANNER.close();
                return;
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
            carService.findCars(filter, target).forEach(System.out::println);
            System.out.println("\t======================");
        }
    }

    private static String getInput(String msg) {
        System.out.printf("[%s] <== ", msg);
        return SCANNER.nextLine();
    }

    private static void printPromptInfo(String token) {
        System.out.printf("Input %s as <%s>%n",
                FILTER_SERVICE.getAll().get(token).info(),
                FILTER_SERVICE.getAll().get(token).prompt()
        );
    }

    private static void printTokensInfo() {
        System.out.println("Input type of search as one of:");
        FILTER_SERVICE.getAll().forEach((t, f) -> System.out.printf("[%s] - %s%n", t, f.info()));
        System.out.println("or\n[q] - for quit search");
    }
}
