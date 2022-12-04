package lesson_21_immutable.task_1;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(checkContainsCar(inputTargetCar(), getMockCars()));
    }

    private static Car[] getMockCars() {
        Car car0 = new Car("Honda", "Civic", 2008, 56456456);
        Car car1 = new Car("Toyota", "Hilux", 2017, 248466145);
        Car car2 = new Car("Ford", "F-150", 2010, 44564361);
        Car car3 = new Car("Volkswagen", "Golf", 2000, 44187896);
        Car car4 = new Car("Chevrolet", "Impala", 1980, 56456456);

        return new Car[]{car0, car1, car2, car3, car4};
    }

    private static Car inputTargetCar() {
        System.out.print("brand <== ");
        String brand = SC.nextLine();

        System.out.print("model <== ");
        String model = SC.nextLine();

        System.out.print("year <== ");
        int year = SC.nextInt();

        System.out.print("serial <== ");
        int serial = SC.nextInt();

        return new Car(brand, model, year, serial);
    }

    private static String checkContainsCar(Car targetCar, Car[] cars) {
        for (int ind = 0; ind < cars.length; ind++) {
            if (targetCar.hashCode() == cars[ind].hashCode() && targetCar.equals(cars[ind])) {
                return String.format("(%d) %s", ind, cars[ind].toString());
            }
        }

        return "Car not found";
    }
}
