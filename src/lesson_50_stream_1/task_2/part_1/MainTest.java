package lesson_50_stream_1.task_2.part_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static List<Employee> employeeList;
    static Main main;

    @BeforeAll
    static void setUp() {
        main = new Main();

        employeeList = List.of(
                new Employee("Vasya", "mechanic", 50_000),
                new Employee("Petya", "mechanic", 50_000),
                new Employee("Zhora", "engineer", 75_000),
                new Employee("Kolya", "engineer", 75_000),
                new Employee("Ibragim", "manager", 99_000),
                new Employee("Pafnutiy", "manager", 99_000)
        );
    }

    @Test
    void groupByJobTitle() {
        assertEquals(main.groupByJobTitle(employeeList), main.groupByJobTitleStream(employeeList));
    }

    @Test
    void calculateAverage() {
        assertEquals(main.calculateAverage(employeeList), main.calculateAverageStream(employeeList));
    }
}