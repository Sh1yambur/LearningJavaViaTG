package lesson_30_regex.task_2;

public class FullName {
    private String firstName;
    private String secondName;
    private String lastName;

    public FullName(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "full name {%s %s %s}".formatted(lastName, firstName, secondName);
    }
}
