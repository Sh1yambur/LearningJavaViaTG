package lesson_32_files_1.task_3;

public class Task {
    private static final String PATH = "./resource/task_32/cars_catalog.dat";

    public static void main(String[] args) {
        CarRepository repository = new CarRepository(PATH);
        //System.out.println(repository);

        Car uaz = new Car("UAZ", "Patriot", 2020);
        repository.add(uaz);
        System.out.println(repository);

        //repository.update(uaz, null, null, 2021);
        //System.out.println(repository);

        //repository.delete(uaz);
        //System.out.println(repository);
    }
}
