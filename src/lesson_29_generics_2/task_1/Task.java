package lesson_29_generics_2.task_1;

/*
 * Реализуйте обобщенный тип, хранящий параметризованное поле.
 * Также в классе Main реализуйте параметризованый метод,
 * который принимает первым параметром объект вашего дженерика,
 * вторым — объект типа, которым параметризован объект первого параметра.
 * Метод должен возвращать значение поля дженерика, если оно != null,
 * в противном случае — возвращать второй параметр.
 */

public class Task {
    public static void main(String[] args) {
        CustomType<String> customType1 = new CustomType<>("forty two");
        CustomType<String> customType2 = new CustomType<>(null);

        System.out.println(getValue(customType1, "42"));
        System.out.println(getValue(customType2, "42"));
    }

    private static <T> T getValue(CustomType<T> customType, T typeValue) {
        T value = customType.getValue();
        if (value != null) {
            return value;
        } else {
            return typeValue;
        }
    }
}
