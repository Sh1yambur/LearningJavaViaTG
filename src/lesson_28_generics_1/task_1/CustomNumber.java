package lesson_28_generics_1.task_1;

public class CustomNumber <T extends Number>{
    private final T value;

    public CustomNumber(T value) {
        this.value = value;
    }

    public Double pow(int exp){
        double result = value.doubleValue();

        for (int i = 1; i < exp; i++) {
            result = result * value.doubleValue();
        }

        return result;
    }
}
