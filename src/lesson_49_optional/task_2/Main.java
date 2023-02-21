package lesson_49_optional.task_2;

/*
 * Реализуйте рад классов:
 * 1. Жилье, должен иметь поле «адрес»;
 * 2. Человек. Поля – «имя», «мать», «отец», «дети», «жилье», «машина», «профессия»;
 * 3. Машина. Предлагаю взять реализацию из Задачи 1 и добавить к ней поле «владелец» типа «Человек».
 *
 * Реализуйте поиск адреса проживания первого ребенка владельца машины с заданным номером и годом выпуска.
 * Используйте реализацию поиска машины из Задачи 1. Изменять ее под требования текущей задачи – недопустимо.
 *
 * Поиск должен быть прекращен, если совпало хотя бы одно из условий:
 * · машина новее 2021 года;
 * · профессия владельца машины или его первого ребенка – «полицейский»;
 * · адрес проживания содержит подстроку «Рублевское шоссе».
 * В таких случаях ничего не должно быть найдено.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        /*carService.findCar(createCar())
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Car not found")
                );*/

        CarIdentifier target = new CarIdentifier("RR-333-RR", 2017);
        carService.findCarOwnerFirstChildAddress(target)
                .ifPresentOrElse(
                        residence -> System.out.println(residence.address()),
                        () -> System.out.println("Car not found")
                );
    }

    private static CarIdentifier createCar() {
//        Неудачный шаг со сканером, повторно использовать метод createCar() мы не сможем.
//        Спишем на условности
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        scanner.close();

        return new CarIdentifier(number, year);
    }

    private static Car[] initCars() {
        Person person1 = new Person("One", null, null);
        person1.setProfession("m.d.");
        person1.setResidence(new Residence("Patriki"));

        Person person2 = new Person("Two", null, person1);
        person1.setChildren(person2);
        person2.setProfession("lawyer");
        person2.setResidence(new Residence("Patriki"));

        Car car1 = new Car("RR-111-RR", 2015, "yellow", true, person1);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true, person1);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true, person1);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true, person1);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true, person1);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true, person1);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true, person1);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true, person1);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true, person1);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true, person1);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
