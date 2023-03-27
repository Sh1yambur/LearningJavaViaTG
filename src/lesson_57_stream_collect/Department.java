package lesson_57_stream_collect;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private int vacancyAmount;

    public Department(String name, List<Employee> employees, int vacancyAmount) {
        this.name = name;
        this.employees = employees;
        this.vacancyAmount = vacancyAmount;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getVacancyAmount() {
        return vacancyAmount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", vacancyAmount=" + vacancyAmount +
                '}';
    }
}
