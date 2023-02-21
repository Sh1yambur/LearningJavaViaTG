package lesson_47_method_reference.task_3;

import java.util.Map;

public class FilterService {
    private final Map<String, Filter> filters;

    public FilterService() {
        filters = Map.of(
                "n", new Filter("number of car", "number", this::filterByNumber),
                "s", new Filter("substring in car number", "number", this::filterBySubstring),
                "b", new Filter("brand of car", "word", this::filterByBrand),
                "y", new Filter("years period of produced", "begin-end", this::filterByYear)
        );
        // search by brand field instead of searching by color field, as in the task description
    }

    public Map<String, Filter> getAll() {
        return filters;
    }

    private boolean filterByNumber(Car car, String target) {
        return car.getSerialNumber() == Integer.parseInt(target);
    }

    private boolean filterBySubstring(Car car, String target) {
        return String.valueOf(car.getSerialNumber()).contains(target);
    }

    private boolean filterByBrand(Car car, String target) {
        return car.getBrand().equalsIgnoreCase(target);
    }

    private boolean filterByYear(Car car, String target) {
        int[] years = parseYears(target);
        // some logic of validate correct years period

        return car.getProducedYear() >= years[0] && car.getProducedYear() <= years[1];
    }

    private int[] parseYears(String input) {
        // parsing of the years period string is deliberately simplified
        String[] str = input.split("-");

        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
}
