package lesson_47_method_reference.task_3;

/*
 * Реализуйте Задачу 3 из урока 46 (),
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис, если это не было сделано ранее.
 */

public class Main {
    public static void main(String[] args) {
        Menu.setCarService(new CarService(getMockCars()));
        Menu.execute();
    }

    private static Car[] getMockCars() {
        return new Car[]{
                new Car("Honda", "Civic", 2008, 56456456),
                new Car("Toyota", "Hilux", 2017, 248466145),
                new Car("Ford", "F-150", 2010, 44564361),
                new Car("Volkswagen", "Golf", 2000, 44187896),
                new Car("Chevrolet", "Impala", 1980, 56456456)
        };
    }
}
