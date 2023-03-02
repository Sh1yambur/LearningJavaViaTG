package lesson_50_stream_1.task_2.part_1;

public class Employee {
    private String name;
    private String title;
    private int salary;

    public Employee(String name, String title, int salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getSalary() {
        return salary;
    }
}
